package com.nhom13.Component;

import com.nhom13.DAO.KhuyenMaiDAO;
import com.nhom13.Dialog.Feature;
import com.nhom13.Dialog.SalePopup;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.KhuyenMai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SaleManager extends ManagerView {

    private List<KhuyenMai> listSale;
    private Employee emp;
    SalePopup form;

    public SaleManager(SalePopup form, Employee emp) {
        super();
        setHeaderTable("ID đợt", "Ngày bắt đầu", "Ngày kết thúc", "Phần trăm KM", "Lí do");
        loadData();
        this.form = form;
        this.emp = emp;
        AddEventListener();
        btnEdit.setEnabled(false);
        btnRemove.setEnabled(false);
    }

    public void getData() {
        try {
            KhuyenMaiDAO dao = new KhuyenMaiDAO();
            listSale = dao.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadData() {
        getData();
        tblModel.setRowCount(0);
        for (KhuyenMai sale : listSale) {
            Object[] row = new Object[]{sale.getId(), sale.getNgayApDung(), sale.getNgayKetThuc(), sale.getGiaTri(), sale.getLyDo()};
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }

    public KhuyenMai getSaleIsSelected() {
        int row = tblData.getSelectedRow();
        if (row >= 0) {
            return listSale.get(row);
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
                    btnRemove.setEnabled(true);
                }
            }

        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setStatus(false);
                form.setFeature(Feature.ADD, null);
                form.setVisible(true);
                if (form.isStatus()) {
                    loadData();
                }
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setStatus(false);
                form.setFeature(Feature.EDIT, getSaleIsSelected());
                form.setVisible(true);
                if (form.isStatus()) {
                    loadData();
                    btnEdit.setEnabled(false);
                    btnRemove.setEnabled(false);
                }
            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    KhuyenMaiDAO dao = new KhuyenMaiDAO();
                    JOptionPane.showMessageDialog(new java.awt.Frame(), "Xóa khuyến mãi thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dao.deleteKhuyenMai(getSaleIsSelected());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                loadData();
                btnEdit.setEnabled(false);
                btnRemove.setEnabled(false);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
                btnEdit.setEnabled(false);
                btnRemove.setEnabled(false);
            }
        });
        btnSearch.addActionListener((e) -> {
            String keyword = txtSearch.getText();
            KhuyenMaiDAO dao = new KhuyenMaiDAO();
            if (isValidDate(keyword)) {
                listSale = dao.searchByDate(keyword);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng yyyy-MM-dd");
            }
            tblModel.setRowCount(0);
            for (KhuyenMai sale : listSale) {
                Object[] row = new Object[]{sale.getId(), sale.getNgayApDung(), sale.getNgayKetThuc(), sale.getGiaTri(), sale.getLyDo()};
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();

        });
    }

    public boolean isValidDate(String keyword) {
        var regex = "^\\d{4}(/|-)\\d{2}(/|-)\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(keyword);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
