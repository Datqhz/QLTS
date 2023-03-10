package com.nhom13.Component;

import javax.swing.ImageIcon;

public class MenuItem extends javax.swing.JPanel {
//    private int index;

    private boolean active;
    private int index;

    public MenuItem(String menuName, int index, String path) {
        initComponents();
        lblIcon.setIcon(new ImageIcon(getClass().getResource(path)));
        lblMenuName.setText(menuName);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        if (active) {
            setBackground(new java.awt.Color(204, 220, 210));
        } else {
            setBackground(new java.awt.Color(204, 227, 231));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblMenuName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 227, 231));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        setMaximumSize(new java.awt.Dimension(32767, 65));
        setMinimumSize(new java.awt.Dimension(254, 37));

        lblIcon.setText(" ");
        lblIcon.setPreferredSize(new java.awt.Dimension(25, 25));

        lblMenuName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMenuName.setText(" ");
        lblMenuName.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblMenuName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMenuName;
    // End of variables declaration//GEN-END:variables
}
