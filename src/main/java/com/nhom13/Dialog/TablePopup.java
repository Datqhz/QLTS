package com.nhom13.Dialog;

import com.nhom13.DAO.BanDAO;
import com.nhom13.Entity.Ban;
import static com.nhom13.Support.UpperCaseFilter.convertToUpperCase;
import javax.swing.JOptionPane;

public class TablePopup extends javax.swing.JDialog {

    private String maNV;
    private boolean status;
    Task task;
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

    public void setTask(Task task, Ban ban) {
        this.task = task;

        if (task == Task.EDIT) {
            setTitle("Sủa thông tin bàn");
            btnTask.setText("Sửa");
            this.ban = ban;
            txtTenBan.setText(ban.getTenBan());
            txtTenBan.setEnabled(false);
            cbxStatus.setSelectedIndex(ban.getTrangThai() ? 1 : 0);
        } else {
            setTitle("Thêm bàn");
            txtTenBan.setEnabled(true);
            btnTask.setText("Thêm");
            this.ban = new Ban();
            txtTenBan.setText("");
            cbxStatus.setSelectedIndex(-1);
        }

    }

    public boolean checkTableName(String name) {
        try {
            BanDAO dao = new BanDAO();
            Ban ban = dao.findByName(name);
            if (ban == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
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
        btnTask = new com.nhom13.swingCustom.ButtonCustom();
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

        btnTask.setBorder(null);
        btnTask.setForeground(new java.awt.Color(255, 255, 255));
        btnTask.setText("Thêm");
        btnTask.setBorderColor(new java.awt.Color(255, 255, 255));
        btnTask.setColor(new java.awt.Color(0, 0, 204));
        btnTask.setColorClick(new java.awt.Color(0, 0, 153));
        btnTask.setColorOver(new java.awt.Color(0, 255, 255));
        btnTask.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTask.setRadius(10);
        btnTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaskActionPerformed(evt);
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
                    .addComponent(btnTask, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnTask, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaskActionPerformed
        String tenBan = txtTenBan.getText().trim();
        boolean tt = cbxStatus.getSelectedIndex() == 0 ? false : true;
        if (tenBan.length() == 0 || tenBan.equals("") && cbxStatus.getSelectedIndex() >= 0) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                BanDAO dao = new BanDAO();
                if (task == Task.ADD) {
                    if (checkTableName(tenBan)) {
                        JOptionPane.showMessageDialog(rootPane, "Tên bàn đã tồn tại.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Ban ban1 = new Ban();
                        long millis = System.currentTimeMillis();
                        java.sql.Date date = new java.sql.Date(millis);
                        ban1.setTenBan(tenBan);
                        ban1.setNgayTao(date);
                        ban1.setTrangThai(tt);
                        JOptionPane.showMessageDialog(rootPane, "Thêm bàn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        dao.save(ban1);
                        status = true;
                        this.dispose();
                    }

                } else {
                    if (tt != ban.getTrangThai()) {
                        ban.setTrangThai(tt);
                        dao.update(ban);
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật trạng thái thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        status = true;
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Trạng thái bàn chưa được thay đổi.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    }

                }

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnTaskActionPerformed

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
    private com.nhom13.swingCustom.ButtonCustom btnTask;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtTenBan;
    // End of variables declaration//GEN-END:variables
}
