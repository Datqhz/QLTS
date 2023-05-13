package com.nhom13.Component;

import com.nhom13.DAO.KhuyenMaiDAO;
import com.nhom13.DAO.LoaiMonDao;
import com.nhom13.DAO.MonAnDAO;
import com.nhom13.Dialog.Task;
import com.nhom13.Dialog.FoodCategoryPopup;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.KhuyenMai;
import com.nhom13.Entity.LoaiMon;
import com.nhom13.Entity.MonAn;
import com.nhom13.Support.CharFilterAlphabet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class FoodCategory extends ManagerView {

    private Employee emp;
    private List<LoaiMon> loaiMons;
    FoodCategoryPopup form;

    public FoodCategory(FoodCategoryPopup form) {//, Employee emp
        super();
        setHeaderTable("ID loại", "Tên loại");
        loadData();
        this.form = form;
        this.emp = emp;
        AddEventListener();
        btnEdit.setEnabled(false);
        btnRemove.setEnabled(false);
        AbstractDocument document1 = (AbstractDocument) txtSearch.getDocument();
        document1.setDocumentFilter(new CharFilterAlphabet());
    }

    private void getData() {
        try {
            LoaiMonDao dao = new LoaiMonDao();
            loaiMons = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        getData();
        tblModel.setRowCount(0);
        for (LoaiMon lm : loaiMons) {
            Object[] row = new Object[]{lm.getId(), lm.getTen()};
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();

    }

    public LoaiMon getCategoryIsSelected() {
        int row = tblData.getSelectedRow();
        if (row >= 0) {
            return loaiMons.get(row);
        }
        return null;
    }

    private void AddEventListener() {
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
                form.setTask(Task.ADD, null);
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
                form.setTask(Task.EDIT, getCategoryIsSelected());
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
                if (getFood(getCategoryIsSelected().getId())) {
                    try {
                        LoaiMonDao dao = new LoaiMonDao();
                        int result = JOptionPane.showConfirmDialog(tblData, "Bạn có chắc muốn xóa không", "Xác nhận",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if (result == 0) {
                            JOptionPane.showMessageDialog(new java.awt.Frame(), "Xóa loại món thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                            dao.deleteLoaiMon(getCategoryIsSelected());
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    loadData();
                    btnEdit.setEnabled(false);
                    btnRemove.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(new java.awt.Frame(), "Có món ăn thuộc loại món này, Không thể xóa.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
                }

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

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = txtSearch.getText();
                if (keyword != null || keyword.length() > 0) {
                    LoaiMonDao dao = new LoaiMonDao();
                    try {
                        loaiMons = dao.SearchLoaiMon(keyword);
                        tblModel.setRowCount(0);
                        for (LoaiMon lm : loaiMons) {
                            Object[] row = new Object[]{lm.getId(), lm.getTen()};
                            tblModel.addRow(row);
                        }
                        tblModel.fireTableDataChanged();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(btnSearch, "Vui lòng nhập tên món ăn muốn tìm kiếm","Lỗi",JOptionPane.WARNING_MESSAGE);
                }

            }

        });
    }

    public boolean getFood(int id) {
        try {
            List<MonAn> templist = new ArrayList<>();
            MonAnDAO monAnDAO = new MonAnDAO();
            templist = monAnDAO.findByCategory(id);
            if (!templist.isEmpty()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
