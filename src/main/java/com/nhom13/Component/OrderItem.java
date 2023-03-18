
package com.nhom13.Component;

import static com.nhom13.Component.BillItem.NumberVN;
import com.nhom13.Entity.CTSP;
import com.nhom13.Entity.ChiTietHoaDon;
import com.nhom13.Entity.MonAn;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class OrderItem extends javax.swing.JPanel {
    CTSP ct;
    public OrderItem() {
        initComponents();
    }

    public JButton getBtnMinus() {
        return btnMinus;
    }

    public void setBtnMinus(JButton btnMinus) {
        this.btnMinus = btnMinus;
    }

    public JButton getBtnPlus() {
        return btnPlus;
    }

    public void setBtnPlus(JButton btnPlus) {
        this.btnPlus = btnPlus;
    }

    public JLabel getLblRemove() {
        return lblRemove;
    }

    public void setLblRemove(JLabel lblRemove) {
        this.lblRemove = lblRemove;
    }

    public JTextField getTxtSL() {
        return txtSL;
    }

    public void setTxtSL(JTextField txtSL) {
        this.txtSL = txtSL;
    }

    public CTSP getCt() {
        return ct;
    }

    public void setCt(CTSP ct) {
        this.ct = ct;
    }
    
    public void setQuantity(int sl){
        txtSL.setText(Integer.toString(sl));
    }
    public int Quantity(){
        return Integer.parseInt(txtSL.getText());
    }
    public void setInfo(CTSP ct, String tenMon) {
        this.ct=ct;
        switch (ct.getIdSize()) {
            case 1:
                lblFoodSize.setText("Size M");
                break;
            case 2:
                lblFoodSize.setText("Size L");
                break;
            default:
                lblFoodSize.setText("Size XL");
                break;
        }
        setOverflowText(tenMon);
        lblPrice.setText(NumberVN(ct.getGia()));
    }
    
        private void setOverflowText(String text) {
        if (text.length() > 30) {
            text = text.substring(0, 30) + "...";
        }
        lblFoodName.setText(text);
    }
    public void increase(){
        txtSL.setText(Integer.toString((Integer.parseInt(txtSL.getText())+1)));
    }
     public void decrease(){
        txtSL.setText(Integer.toString((Integer.parseInt(txtSL.getText())-1)));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSL = new javax.swing.JTextField();
        btnMinus = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();
        lblFoodName = new javax.swing.JLabel();
        lblFoodSize = new javax.swing.JLabel();
        lblRemove = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 0));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(350, 60));
        setMinimumSize(new java.awt.Dimension(350, 60));
        setPreferredSize(new java.awt.Dimension(350, 60));

        txtSL.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnMinus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minus.png"))); // NOI18N
        btnMinus.setPreferredSize(new java.awt.Dimension(17, 17));

        btnPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus.png"))); // NOI18N
        btnPlus.setPreferredSize(new java.awt.Dimension(17, 17));

        lblFoodName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblFoodName.setText("Trà sữa trân châu");

        lblFoodSize.setText("M");

        lblRemove.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N

        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrice.setText("50.000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRemove)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFoodSize, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFoodName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFoodName)
                    .addComponent(lblRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFoodSize)
                        .addComponent(lblPrice))
                    .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(4, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnPlus;
    private javax.swing.JLabel lblFoodName;
    private javax.swing.JLabel lblFoodSize;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblRemove;
    private javax.swing.JTextField txtSL;
    // End of variables declaration//GEN-END:variables
}
