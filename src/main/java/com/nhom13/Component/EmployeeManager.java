package com.nhom13.Component;

import com.nhom13.DAO.EmployeeDAO;
import com.nhom13.Dialog.EmployeePopup;
import com.nhom13.Dialog.Feature;
import com.nhom13.Entity.Employee;
import com.nhom13.Support.CharFilterAlphabet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class EmployeeManager extends ManagerView {

    EmployeePopup dialog;
    List<Employee> listEmp;

    public EmployeeManager(EmployeePopup dialog) {//
        super();
        setHeaderTable("Mã nhân viên", "Họ tên", "Account", "Số điện thoại", "Địa chỉ", "Giới tính", "Chức vụ", "Trạng thái");
        this.dialog = dialog;
        btnRemove.setVisible(false);
        btnEdit.setEnabled(false);
        loadData();
        AddEventListener();
        AbstractDocument document1 = (AbstractDocument) txtSearch.getDocument();
        document1.setDocumentFilter(new CharFilterAlphabet());
    }

    public void getData() {
        try {
            EmployeeDAO dao = new EmployeeDAO();
            listEmp = dao.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadData() {
        getData();
        tblModel.setRowCount(0);
        for (Employee emp : listEmp) {

            Object[] row = new Object[]{emp.getMaNV(), emp.getFirstName() + " " + emp.getLastName(), emp.getAccount().getTenTk(),
                (emp.getSdt() == null) ? "" : emp.getSdt(), emp.getDiachi(), emp.getGioiTinh(), RoleName(emp.getAccount().getIdQuyen()), StatusName(emp.getAccount().isTrangThai())};
            tblModel.addRow(row);
//            System.out.println(emp.getAccount().toString());
        }
        tblModel.fireTableDataChanged();
    }

    public String RoleName(int role) {
        return (role == 1) ? "Nhân viên" : "Quản lý";
    }

    public String StatusName(boolean status) {
        return status ? "Hoạt động" : "Đã khóa";
    }

    public Employee getRowIsSelected() {
        int row = tblData.getSelectedRow();
        if (row >= 0) {
            return listEmp.get(row);
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
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setFeature(Feature.ADD, null);
                dialog.setStatus(false);
                dialog.setVisible(true);
                if (dialog.isStatus()) {
                    loadData();
                }
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee temp = getRowIsSelected();
//                System.out.println(temp.getAccount().toString());
                dialog.setFeature(Feature.EDIT, temp);
                dialog.setStatus(false);
                dialog.setVisible(true);
                if (dialog.isStatus()) {
                    loadData();

                }
                btnEdit.setEnabled(false);
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
                btnEdit.setEnabled(false);
            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = txtSearch.getText().trim();
                if (keyword != null && keyword.length() > 0) {
                    EmployeeDAO dao = new EmployeeDAO();
                    try {
                        listEmp = dao.searchNhanVienByName(keyword);
                        tblModel.setRowCount(0);
                        for (Employee emp : listEmp) {
                            Object[] row = new Object[]{emp.getMaNV(), emp.getFirstName() + " " + emp.getLastName(), emp.getAccount().getTenTk(),
                                (emp.getSdt() == null) ? "" : emp.getSdt(), emp.getDiachi(), emp.getGioiTinh(), RoleName(emp.getAccount().getIdQuyen()), StatusName(emp.getAccount().isTrangThai())};
                            tblModel.addRow(row);
                        }
                        tblModel.fireTableDataChanged();

                    } catch (Exception ex) {
                    }

                } else {
                    JOptionPane.showMessageDialog(btnSearch, "Vui lòng nhập tên món ăn muốn tìm kiếm", "Lỗi", JOptionPane.WARNING_MESSAGE);
                    
                }

            }
        });
    }
}
