package com.nhom13.Component;

import com.nhom13.Entity.MonAn;
import java.awt.Image;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FoodItem extends javax.swing.JPanel {

    private MonAn food;

    public FoodItem(MonAn food) {
        initComponents();
        this.food = food;
        loadInfo(food);
    }

    public String NumberVN(double s) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        return vn.format(s);
    }

    public Icon Resize(String path, int k, int m) {
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }

    public void loadInfo(MonAn food) {
        if (food.getAnh() != null) {
            lblImage.setIcon(Resize(food.getAnh(), 60, 60));
        }
        lblFoodName.setText(food.getTenMon());
        lblPrice.setText(NumberVN(food.getGia()) + " / " + food.getDonVi());
    }

    public MonAn getFood() {
        return food;
    }

    public void setFood(MonAn food) {
        this.food = food;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblFoodName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(60, 60));

        lblFoodName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblFoodName.setForeground(new java.awt.Color(255, 255, 255));
        lblFoodName.setText("Trà sữa trân châu");

        lblPrice.setBackground(new java.awt.Color(255, 0, 0));
        lblPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblPrice.setText("50,000 / Ly");

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new.png"))); // NOI18N
        lblImage.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFoodName, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFoodName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrice)
                        .addGap(10, 10, 10))
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFoodName;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPrice;
    // End of variables declaration//GEN-END:variables
}
