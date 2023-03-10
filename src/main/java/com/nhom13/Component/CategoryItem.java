package com.nhom13.Component;

import com.nhom13.Entity.LoaiMon;
import java.util.Random;

public class CategoryItem extends javax.swing.JPanel {

    private LoaiMon category;

    public CategoryItem(LoaiMon category) {
        initComponents();
        this.category = category;
        setContent();
    }

    public LoaiMon getCategory() {
        return category;
    }

    public void setCategory(LoaiMon category) {
        this.category = category;
    }

    public void setContent() {
        Random rand = new Random();
        lblCategory.setText(category.getTen());
        setBackground(new java.awt.Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCategory = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 204));
        setMaximumSize(new java.awt.Dimension(180, 58));
        setMinimumSize(new java.awt.Dimension(180, 58));

        lblCategory.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(255, 255, 255));
        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategory.setText("TRÀ SỮA");
        lblCategory.setPreferredSize(new java.awt.Dimension(55, 18));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCategory;
    // End of variables declaration//GEN-END:variables
}
