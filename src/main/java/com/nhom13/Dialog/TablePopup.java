package com.nhom13.Dialog;

import com.nhom13.Support.UpperCaseFilter;
import com.nhom13.DAO.BanDAO;
import com.nhom13.DAO.CTBanDAO;
import com.nhom13.Entity.Ban;
import com.nhom13.Entity.ChiTietBan;
import com.nhom13.Entity.KhuyenMai;
import static com.nhom13.Support.UpperCaseFilter.convertToUpperCase;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class TablePopup extends javax.swing.JDialog {

    private String maNV;
    private boolean status;
    Feature feature;
    private Ban ban;

    public TablePopup(java.awt.Frame parent, String maNV) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        this.maNV = maNV;
        cbxStatus.addItem("Trống");
        cbxStatus.addItem("Đang sử dụng");
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setFeature(Feature task, Ban ban) {
        feature = task;

        if (task == Feature.EDIT) {
            btnFeature.setText("Sửa");
            this.ban = ban;
            txtTenBan.setText(ban.getTenBan());
            txtTenBan.setEnabled(false);
            cbxStatus.setSelectedIndex(ban.getTrangThai() ? 1 : 0);
        } else {
            btnFeature.setText("Thêm");
            this.ban = ban;
            txtTenBan.setText("");
            cbxStatus.setSelectedIndex(-1);
        }

    }

    public boolean checkTableName(String name) {
        try{
            BanDAO dao = new BanDAO();
            Ban ban = dao.findhByName(name);
            if(ban!=null){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTenBan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnClose = new com.nhom13.swingCustom.ButtonCustom();
        btnFeature = new com.nhom13.swingCustom.ButtonCustom();
        jLabel3 = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtTenBan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTenBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenBanKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Tên bàn");

        btnClose.setBorder(null);
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Đóng");
        btnClose.setBorderColor(new java.awt.Color(255, 255, 255));
        btnClose.setColor(new java.awt.Color(0, 0, 204));
        btnClose.setColorClick(new java.awt.Color(0, 0, 153));
        btnClose.setColorOver(new java.awt.Color(0, 255, 255));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setRadius(10);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnFeature.setBorder(null);
        btnFeature.setForeground(new java.awt.Color(255, 255, 255));
        btnFeature.setText("Thêm");
        btnFeature.setBorderColor(new java.awt.Color(255, 255, 255));
        btnFeature.setColor(new java.awt.Color(0, 0, 204));
        btnFeature.setColorClick(new java.awt.Color(0, 0, 153));
        btnFeature.setColorOver(new java.awt.Color(0, 255, 255));
        btnFeature.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFeature.setRadius(10);
        btnFeature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeatureActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Trạng thái:");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFeatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeatureActionPerformed
        String tenBan = txtTenBan.getText().trim();
        boolean tt = cbxStatus.getSelectedIndex() == 0 ? false : true;
        if (tenBan.length() == 0 || tenBan.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Not Blank");
        } else if(checkTableName(tenBan)){
            JOptionPane.showMessageDialog(rootPane, "Tên bàn đã tồn tại.");
        }else {

            try {

                BanDAO dao = new BanDAO();
                if (feature == Feature.ADD) {
                    Ban ban1 = new Ban();
                    long millis = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    ban1.setTenBan(tenBan);
                    ban1.setNgayTao(date);
                    ban1.setTrangThai(tt);
                    JOptionPane.showMessageDialog(rootPane, "Add Successful");
                    dao.save(ban1);
                } else {
                    if (tt != ban.getTrangThai()) {
                        ban.setTrangThai(tt);
                        dao.update(ban);
                        CTBanDAO ctdao = new CTBanDAO();
                        ChiTietBan ct = new ChiTietBan(tt, ban.getId(), maNV);
                        ctdao.save(ct);
                        JOptionPane.showMessageDialog(rootPane, "Update successful");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Trạng thái bàn chưa được thay đổi.");
                    }

                }
                status = true;
                this.dispose();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnFeatureActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtTenBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenBanKeyReleased
        convertToUpperCase(txtTenBan);
    }//GEN-LAST:event_txtTenBanKeyReleased

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TablePopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TablePopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TablePopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TablePopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                TablePopup dialog = new TablePopup(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom13.swingCustom.ButtonCustom btnClose;
    private com.nhom13.swingCustom.ButtonCustom btnFeature;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtTenBan;
    // End of variables declaration//GEN-END:variables
}
