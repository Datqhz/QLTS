package com.nhom13.Dialog;

import com.nhom13.DAO.TaiKhoanDAO;
import javax.swing.JOptionPane;

public class ChangePassword extends javax.swing.JDialog {

    private String oldPass;
    private String newPass;
    private boolean status;

    public ChangePassword(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void ResetForm() {
        lblError.setText("");
        txtOldPass.setText("");
        txtNewPass.setText("");
        txtReNewPass.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        txtOldPass = new javax.swing.JPasswordField();
        txtNewPass = new javax.swing.JPasswordField();
        txtReNewPass = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnChange = new com.nhom13.swingCustom.ButtonCustom();
        btnClose = new com.nhom13.swingCustom.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("M???t kh???u hi???n t???i");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("M???t kh???u m???i");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Nh???p l???i m???t kh???u m???i");

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setMaximumSize(new java.awt.Dimension(228, 16));
        lblError.setMinimumSize(new java.awt.Dimension(228, 16));
        lblError.setPreferredSize(new java.awt.Dimension(228, 16));

        txtOldPass.setBorder(null);
        txtOldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOldPassActionPerformed(evt);
            }
        });

        txtNewPass.setBorder(null);

        txtReNewPass.setBorder(null);

        btnChange.setBorder(null);
        btnChange.setForeground(new java.awt.Color(255, 255, 255));
        btnChange.setText("Thay ?????i");
        btnChange.setBorderColor(new java.awt.Color(255, 255, 255));
        btnChange.setColor(new java.awt.Color(0, 102, 255));
        btnChange.setColorClick(new java.awt.Color(0, 51, 204));
        btnChange.setColorOver(new java.awt.Color(0, 255, 255));
        btnChange.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChange.setRadius(10);
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnClose.setBorder(null);
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("H???y");
        btnClose.setBorderColor(new java.awt.Color(255, 255, 255));
        btnClose.setColor(new java.awt.Color(0, 102, 255));
        btnClose.setColorClick(new java.awt.Color(0, 51, 204));
        btnClose.setColorOver(new java.awt.Color(0, 255, 255));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setRadius(10);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator3)
                        .addComponent(txtReNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addComponent(txtNewPass)
                        .addComponent(txtOldPass)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOldPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOldPassActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        String OldPass = new String(txtOldPass.getPassword());
        String newPass = new String(txtNewPass.getPassword());
        String reNewPass = new String(txtReNewPass.getPassword());
        if (OldPass.contains(" ") || newPass.contains(" ")) {
            ResetForm();
            lblError.setText("M???t kh???u kh??ng ???????c ch???a kho???ng tr???ng!");
        } else if (!OldPass.equals(oldPass)) {
            ResetForm();
            lblError.setText("M???t kh???u hi???n t???i kh??ng ????ng. Vui l??ng nh???p l???i!");

        } else if (newPass.equals(oldPass)) {
            ResetForm();
            lblError.setText("M???t kh???u m???i kh??ng ???????c tr??ng v???i m???t kh???u hi???n t???i. Vui l??ng nh???p l???i!");

        } else if (newPass.isBlank()) {
            lblError.setText("Tr?????ng m???t kh???u m???i kh??ng ???????c ????? tr???ng!");
        } else if (newPass.isBlank()) {
            lblError.setText("Tr?????ng nh???p l???i m???t kh???u m???i kh??ng ???????c ????? tr???ng!");
        } else if (!reNewPass.equals(newPass)) {
            ResetForm();
            lblError.setText("M???t kh???u nh???p l???i kh??ng kh???p. Vui l??ng nh???p l???i!");
        } else {
                this.newPass = newPass;
                
                JOptionPane.showMessageDialog(this, "B???n ???? ?????i m???t kh???u th??nh c??ng.", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
                status = true;
            
                ResetForm();
                setVisible(false);
            
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ChangePassword dialog = new ChangePassword(new javax.swing.JFrame(), true, "123456789");
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
    private com.nhom13.swingCustom.ButtonCustom btnChange;
    private com.nhom13.swingCustom.ButtonCustom btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblError;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JPasswordField txtOldPass;
    private javax.swing.JPasswordField txtReNewPass;
    // End of variables declaration//GEN-END:variables
}
