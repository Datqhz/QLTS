package com.nhom13.Dialog;

import com.nhom13.Support.UpperCaseFilter;
import com.nhom13.DAO.LoaiMonDao;
import com.nhom13.Entity.LoaiMon;
import com.nhom13.Support.CharFilterAlphabet;
import static com.nhom13.Support.UpperCaseFilter.convertToUpperCase;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class FoodCategoryPopup extends javax.swing.JDialog {

    private boolean status;
    Feature featute;
    private LoaiMon loaiMon;

    public FoodCategoryPopup(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
//        ((AbstractDocument) txtCategoryName.getDocument()).setDocumentFilter(new UpperCaseFilter());
        AbstractDocument document1 = (AbstractDocument) txtCategoryName.getDocument();
        document1.setDocumentFilter(new CharFilterAlphabet());
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // set chức năng cho dialog(thêm hoặc sửa)
    public void setFeature(Feature task, LoaiMon loaiMon) {
        featute = task;
        if (task == Feature.ADD) {//thêm
            setTitle("Thêm loại món");
            btnFeature.setText("Thêm");
            this.loaiMon = null;
        } else {//sửa
            setTitle("Sủa thông tin loại món");
            btnFeature.setText("Thay đổi");
            this.loaiMon = loaiMon;
            txtCategoryName.setText(loaiMon.getTen());
        }
    }

    public boolean checkTenLoai(String name) {
        try {
            LoaiMonDao dao = new LoaiMonDao();
            LoaiMon temp = dao.SearchTenLoaiMon(name);
            if (temp == null) {
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
        txtCategoryName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnFeature = new com.nhom13.swingCustom.ButtonCustom();
        btnClose = new com.nhom13.swingCustom.ButtonCustom();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtCategoryName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCategoryName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoryNameKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Tên loại");

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

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFeatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeatureActionPerformed
        String tenLoaiMon = txtCategoryName.getText().trim();
        if (tenLoaiMon == null || tenLoaiMon.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Tên loại món không được để trống","Lỗi",JOptionPane.WARNING_MESSAGE);
        } else {
            LoaiMon lm = new LoaiMon(tenLoaiMon);

            try {
                LoaiMonDao lmd = new LoaiMonDao();
                if (featute == Feature.ADD) {
                    if (checkTenLoai(tenLoaiMon)) {
                        JOptionPane.showMessageDialog(rootPane, "Tên loại món đã tồn tại ","Lỗi",JOptionPane.WARNING_MESSAGE);
                    } else {
                        lmd.save(lm);
                        JOptionPane.showMessageDialog(rootPane, "Lưu thông tin thành công","Thành công", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    if (loaiMon.getTen().equals(tenLoaiMon)) {
                        lm.setId(loaiMon.getId());
                        lmd.update(lm);
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin thành công","Thành công", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (checkTenLoai(tenLoaiMon)) {
                            JOptionPane.showMessageDialog(rootPane, "Tên loại món đã tồn tại","Lỗi",JOptionPane.WARNING_MESSAGE);
                        } else {
                            lm.setId(loaiMon.getId());
                            lmd.update(lm);
                            JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin thành công","Thành công", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                }
                status = true;
                txtCategoryName.setText("");

                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnFeatureActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        txtCategoryName.setText("");
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtCategoryNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryNameKeyReleased
        convertToUpperCase(txtCategoryName);
    }//GEN-LAST:event_txtCategoryNameKeyReleased

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
//            java.util.logging.Logger.getLogger(AddFoodCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddFoodCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddFoodCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddFoodCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                FoodCategoryPopup dialog = new FoodCategoryPopup(new javax.swing.JFrame(),"NV01");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCategoryName;
    // End of variables declaration//GEN-END:variables
}
