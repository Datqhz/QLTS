package com.nhom13.Component;

import static com.nhom13.Support.UpperCaseFilter.convertToUpperCase;
import com.nhom13.swingCustom.ButtonCustom;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ManagerView extends javax.swing.JPanel {

    DefaultTableModel tblModel = new DefaultTableModel();

    public ManagerView() {
        initComponents();
        tblData.getTableHeader().setOpaque(false);
        tblData.setBackground(Color.WHITE);
        tblData.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblData.setForeground(new Color(102, 102, 102));
//        tblData.setBorder(new EmptyBorder(10, 5, 10, 5));
        tblData.getTableHeader().setBackground(new Color(51, 175, 255));
        tblData.getTableHeader().setForeground(new Color(255, 255, 255));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblData.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ((DefaultTableCellRenderer) tblData.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        pnCbx.setLayout(new FlowLayout());

        initTable();
    }

    public ButtonCustom getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(ButtonCustom btnAdd) {
        this.btnAdd = btnAdd;
    }

    public ButtonCustom getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(ButtonCustom btnReset) {
        this.btnReset = btnReset;
    }

    public ButtonCustom getBtnSeach() {
        return btnSearch;
    }

    public void setBtnSeach(ButtonCustom btnSeach) {
        this.btnSearch = btnSeach;
    }

    public ButtonCustom getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(ButtonCustom btnEdit) {
        this.btnEdit = btnEdit;
    }

    public ButtonCustom getBtnRemove() {
        return btnRemove;
    }

    public void setBtnRemove(ButtonCustom btnRemove) {
        this.btnRemove = btnRemove;
    }

    public void initTable() {
        tblData.setModel(tblModel);

    }

    public void setHeaderTable(String... fields) {
        tblModel.setColumnIdentifiers(fields);
    }
//    public JTextField getTxtSearch() {
//        return txtSearch;
//    }
//
//    public void setTxtSearch(JTextField txtSearch) {
//        this.txtSearch = txtSearch;
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new com.nhom13.swingCustom.ButtonCustom();
        btnAdd = new com.nhom13.swingCustom.ButtonCustom();
        btnRemove = new com.nhom13.swingCustom.ButtonCustom();
        btnEdit = new com.nhom13.swingCustom.ButtonCustom();
        btnReset = new com.nhom13.swingCustom.ButtonCustom();
        pnCbx = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(0, 255, 153));

        tblData.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblData.setRowHeight(30);
        tblData.setSelectionBackground(new java.awt.Color(0, 0, 255));
        tblData.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblData);

        txtSearch.setToolTipText("");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnSearch.setBorder(null);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search_20.png"))); // NOI18N
        btnSearch.setBorderColor(new java.awt.Color(102, 255, 153));
        btnSearch.setColorClick(new java.awt.Color(0, 204, 51));
        btnSearch.setRadius(10);

        btnAdd.setBorder(null);
        btnAdd.setForeground(new java.awt.Color(0, 0, 102));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setBorderColor(new java.awt.Color(51, 255, 153));
        btnAdd.setColorClick(new java.awt.Color(0, 204, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setRadius(10);

        btnRemove.setBorder(null);
        btnRemove.setForeground(new java.awt.Color(0, 0, 102));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        btnRemove.setText("Xóa");
        btnRemove.setBorderColor(new java.awt.Color(0, 255, 153));
        btnRemove.setColorClick(new java.awt.Color(0, 204, 51));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemove.setRadius(10);

        btnEdit.setBorder(null);
        btnEdit.setForeground(new java.awt.Color(0, 0, 102));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setBorderColor(new java.awt.Color(0, 255, 153));
        btnEdit.setColorClick(new java.awt.Color(0, 204, 51));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setRadius(10);

        btnReset.setBorder(null);
        btnReset.setForeground(new java.awt.Color(0, 0, 102));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync.png"))); // NOI18N
        btnReset.setText("Sync");
        btnReset.setBorderColor(new java.awt.Color(0, 255, 153));
        btnReset.setColorClick(new java.awt.Color(0, 204, 51));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setRadius(10);

        pnCbx.setOpaque(false);

        javax.swing.GroupLayout pnCbxLayout = new javax.swing.GroupLayout(pnCbx);
        pnCbx.setLayout(pnCbxLayout);
        pnCbxLayout.setHorizontalGroup(
            pnCbxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        pnCbxLayout.setVerticalGroup(
            pnCbxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(pnCbx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        convertToUpperCase(txtSearch);
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected com.nhom13.swingCustom.ButtonCustom btnAdd;
    protected com.nhom13.swingCustom.ButtonCustom btnEdit;
    protected com.nhom13.swingCustom.ButtonCustom btnRemove;
    protected com.nhom13.swingCustom.ButtonCustom btnReset;
    protected com.nhom13.swingCustom.ButtonCustom btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JPanel pnCbx;
    protected javax.swing.JTable tblData;
    protected javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
