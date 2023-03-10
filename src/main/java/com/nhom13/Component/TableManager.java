package com.nhom13.Component;

import com.nhom13.DAO.BanDAO;
import com.nhom13.DAO.KhuyenMaiDAO;
import com.nhom13.Dialog.TablePopup;
import com.nhom13.Dialog.Feature;
import com.nhom13.Entity.Ban;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.KhuyenMai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public final class TableManager extends ManagerView {

    private List<Ban> bans = new ArrayList<>();
    private Employee emp;
    TablePopup form;
    JComboBox<String> cbxSearch = new JComboBox<>();

    public TableManager(TablePopup form, Employee emp) {
        super();
        setHeaderTable("ID Bàn", "Tên bàn", "Trạng thái");
        loadData();
        this.form = form;
        this.emp = emp;
        AddEventListener();
        btnEdit.setEnabled(false);
        btnRemove.setEnabled(false);
        cbxSearch = new JComboBox<>();
        cbxSearch.removeAllItems();
        cbxSearch.addItem("Tên bàn");
        cbxSearch.addItem("Bàn còn trống");
        pnCbx.add(cbxSearch);
    }

    public Ban getBanSelected() {
        int row = tblData.getSelectedRow();
        if (row >= 0) {
            return bans.get(row);
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

        btnAdd.addActionListener((ActionEvent e) -> {
            form.setStatus(false);
            form.setFeature(Feature.ADD, null);
            form.setVisible(true);
            if (form.isStatus()) {
                loadData();
            }
        });
        btnEdit.addActionListener((ActionEvent e) -> {
            form.setStatus(false);
            form.setFeature(Feature.EDIT, getBanSelected());
            form.setVisible(true);
            if (form.isStatus()) {
                loadData();
                btnEdit.setEnabled(false);
                btnRemove.setEnabled(false);
            }
        });
        btnRemove.addActionListener((ActionEvent e) -> {
            try {
                BanDAO dao = new BanDAO();
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Xóa bàn thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                dao.deleteBan(getBanSelected());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            loadData();
            btnEdit.setEnabled(false);
            btnRemove.setEnabled(false);
        });

        btnReset.addActionListener((ActionEvent e) -> {
            loadData();
            btnEdit.setEnabled(false);
            btnRemove.setEnabled(false);
        });
        btnSearch.addActionListener(((e) -> {
            String keyword = txtSearch.getText().trim();
            int i = this.cbxSearch.getSelectedIndex();
            BanDAO dao = new BanDAO();
            if (i == 0) {
                bans = dao.searchByName(keyword);
            } else {
                bans = dao.searchTableActive();

            }
            tblModel.setRowCount(0);
            for (Ban ban : bans) {
                Object[] row = new Object[]{ban.getId(), ban.getTenBan(), !ban.getTrangThai() ? "Trống" : "Đang sử dụng"};//0 ->Trống , 1-> Đang sử dụng
                tblModel.addRow(row);
            }
            tblModel.fireTableDataChanged();

        }));

    }

    public void getData() {
        try {
            BanDAO dao = new BanDAO();
            bans = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        getData();
        tblModel.setRowCount(0);
        for (Ban ban : bans) {
            Object[] row = new Object[]{ban.getId(), ban.getTenBan(), !ban.getTrangThai() ? "Trống" : "Đang sử dụng"};//0 ->Trống , 1-> Đang sử dụng
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }

}
