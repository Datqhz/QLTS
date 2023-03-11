package com.nhom13.Component;

import com.nhom13.DAO.HoaDonDao;
import com.nhom13.Dialog.OrderPopup;
import com.nhom13.Dialog.ShowBill;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.HoaDon;
import com.nhom13.Support.CharFilterNumber;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.AbstractDocument;

public class BillList extends ManagerView {

    private Employee emp;
    List<HoaDon> billList = new ArrayList<>();

    public BillList(Employee emp) {
        super();
        setHeaderTable("Số hóa đơn", "Người lập hóa đơn", "Ngày lập", "ID khách hàng", "Thành tiền");
        this.emp = emp;
//        this.remove(btnRemove);
        btnRemove.setVisible(false);
        btnEdit.setText("Xem");
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eye.png")));
        loadData();
        AddEventListener();
        btnEdit.setEnabled(false);;
        AbstractDocument document3 = (AbstractDocument) txtSearch.getDocument();
        document3.setDocumentFilter(new CharFilterNumber());
    }

    public void getData() {
        try {
            HoaDonDao dao = new HoaDonDao();
            billList = dao.findAll();
        } catch (Exception e) {
            System.out.println("Lấy danh sách hóa đơn không thành công");
            e.printStackTrace();
        }
    }

    public void loadData() {
        getData();
        System.out.println(billList);
        tblModel.setRowCount(0);
        for (HoaDon bill : billList) {

            Object[] obj = new Object[]{bill.getSoHoaDon(), bill.getMaNv(), bill.getNgayLap(), bill.getIdKh() != 0 ? bill.getIdKh() : "", bill.getThanhTien()};
            tblModel.addRow(obj);
        }
        tblModel.fireTableDataChanged();
    }
    //Lấy hàng hóa đơn đang được chọn trên bảng
    public HoaDon getRowIsSelected() {
        int row = tblData.getSelectedRow();
        if (row >= 0) {
            return billList.get(row);
        }
        return null;
    }

    public void AddEventListener() {

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblData.getSelectedRow();
                if (row >= 0) {
                    btnEdit.setEnabled(true);
                }
//                System.out.println(getRowIsSelected().getGioiTinh().equals("N"));
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderPopup popup = new OrderPopup(emp);
                popup.setVisible(true);
                System.out.println(popup.isStatus());
                if (popup.isStatus()) {
                    loadData();

                }
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowBill bill = new ShowBill(getRowIsSelected());
                bill.setVisible(true);
                btnEdit.setEnabled(false);
//                tblData.setRowSelectionInterval(-1, -1);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
                btnEdit.setEnabled(false);
            }
        });

        btnSearch.addActionListener((e) -> {
            String keyword = txtSearch.getText().trim();
            if (keyword != null && keyword.length() > 0) {
                HoaDonDao dao = new HoaDonDao();
                billList = dao.findById(Integer.parseInt(keyword));
                tblModel.setRowCount(0);
                Object[] row = new Object[]{billList.get(0).getSoHoaDon(), billList.get(0).getMaNv(), billList.get(0).getNgayLap(),
                     billList.get(0).getIdKh() != 0 ? billList.get(0).getIdKh() : "", billList.get(0).getThanhTien()};
                tblModel.addRow(row);
                tblModel.fireTableDataChanged();

            }

        });
    }
}
