package com.nhom13.ql_ts;

import com.nhom13.Component.BillList;
import com.nhom13.Component.ClientManager;
import com.nhom13.Component.EmployeeManager;
import com.nhom13.Component.FoodCategory;
import com.nhom13.Component.MenuItem;
import com.nhom13.Component.FoodList;
import com.nhom13.Component.Profile;
import com.nhom13.Component.SaleManager;
import com.nhom13.Component.Statistic;
import com.nhom13.Component.StatisticEmployee;
import com.nhom13.Component.TableManager;
import com.nhom13.Dialog.FoodPopup;
import com.nhom13.Dialog.TablePopup;
import com.nhom13.Dialog.SalePopup;
import com.nhom13.Dialog.ChangePassword;
import com.nhom13.Dialog.ClientPopup;
import com.nhom13.Dialog.EmployeePopup;
import com.nhom13.Dialog.FoodPopup;
import com.nhom13.Dialog.FoodCategoryPopup;
import com.nhom13.Entity.Employee;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class Home extends javax.swing.JFrame {

    List<MenuItem> menuItems = new ArrayList<>();
    private Employee emp;
    private MenuItem menuActive = null;

    public Home() {
        initComponents();
        initMenu();
        setLocationRelativeTo(null);
    }

    public Home(Employee emp) {
        initComponents();
        setLocationRelativeTo(null);
        this.emp = emp;
        lblName.setText(emp.getFirstName() + " " + emp.getLastName());
        if (emp.getAccount().getIdQuyen() == 1) {
            lblRole.setText("Nhân viên");
        } else {
            lblRole.setText("Quản lý");
        }

        initMenu();
        panelController.setLayout(new GridLayout(1, 1));
    }

    public void initMenu() {

        MenuItem QLTD = new MenuItem("Quản lí thực đơn.", 1, "/menu.png");
        MenuItem QLB = new MenuItem("Quản lí bàn.", 2, "/table.png");
        MenuItem QLHD = new MenuItem("Quản lí hóa đơn.", 3, "/bill.png");
        MenuItem QLNV = new MenuItem("Quản lí nhân viên.", 4, "/employee.png");
        MenuItem QLKH = new MenuItem("Quản lí khách hàng.", 5, "/client.png");
        MenuItem QLKM = new MenuItem("Quản lí khuyến mãi.", 6, "/sale.png");
        MenuItem TK = new MenuItem("Thống kê.", 7, "/statistical.png");
        MenuItem TTCN = new MenuItem("Thông tin cá nhân.", 8, "/my-info.png");
        pnMenu.setLayout(new BoxLayout(pnMenu, BoxLayout.Y_AXIS));
        addMenu(QLTD, QLB, QLHD, QLNV, QLKH, QLKM, TK, TTCN);
        if (emp.getAccount().getIdQuyen() == 1) {
            QLTD.setVisible(false);
            QLNV.setVisible(false);
            TK.setVisible(false);
            QLKM.setVisible(false);
        }

    }

    public void setActiveMenu(MenuItem item) {
        boolean isActive = item.isActive();
        if (menuActive != null) {
            menuActive.setActive(false);
        }
        if (!isActive) {
            item.setActive(!isActive);
            menuActive = item;
        }
    }

    public void addEvent(MenuItem item) {
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!item.isActive() && !item.equals(menuActive)) {
                    setActiveMenu(item);
                    panelController.removeAll();
                    menuChange(item);
                }

            }

        });
    }

    public void addMenu(MenuItem... items) {
        int length = items.length;
        for (int i = 0; i < length; i++) {
            addEvent(items[i]);
            pnMenu.add(items[i]);
        }
    }

    public void menuChange(MenuItem item) {
        switch (item.getIndex()) {
            case 1:
                panelController.removeAll();
                System.out.println("Quản lí thực đơn");
                JTabbedPane tbb = new JTabbedPane();
                tbb.add("Loại món", new FoodCategory(new FoodCategoryPopup(this)));
                tbb.add("Món ăn", new FoodList());
                panelController.add(tbb);
                repaint();
                revalidate();
                break;
            case 2:
                panelController.removeAll();
                System.out.println("Quản lí bàn");
                panelController.add(new TableManager(new TablePopup(this, emp.getMaNV()), emp));
                repaint();
                revalidate();
                break;
            case 3:
                panelController.removeAll();
                System.out.println("Quản lí hóa đơn");
                panelController.add(new BillList(emp));
                repaint();
                revalidate();
                break;
            case 4:
                panelController.removeAll();
                System.out.println("Quản lí nhân viên");
                panelController.add(new EmployeeManager());//new EmployeePopup(this)
                repaint();
                revalidate();
                break;
            case 5:
                panelController.removeAll();
                panelController.add(new ClientManager(new ClientPopup(this)));
                repaint();
                revalidate();
                break;
            case 6:
                panelController.removeAll();
                System.out.println("Quản lí khuyến mãi");
                panelController.add(new SaleManager(new SalePopup(this, emp.getMaNV()), emp));
                repaint();
                revalidate();
                break;
            case 7:
                panelController.removeAll();
                System.out.println("Thống kê");
                JTabbedPane tbb2 = new JTabbedPane();
                tbb2.add("Theo thời gian", new Statistic());
                tbb2.add("Theo nhân viên", new StatisticEmployee());
                panelController.add(tbb2);
                repaint();
                revalidate();
                break;
            case 8:
                panelController.removeAll();
                System.out.println("Thông tin cá nhân");
                panelController.add(new Profile(new ChangePassword(this), emp));
                repaint();
                revalidate();
                break;
            default:
                System.out.println("Home");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMenu = new javax.swing.JPanel();
        panelController = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        btnLogout = new com.nhom13.swingCustom.ButtonCustom();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        panelController.setBackground(new java.awt.Color(255, 255, 255));
        panelController.setPreferredSize(new java.awt.Dimension(950, 600));

        javax.swing.GroupLayout panelControllerLayout = new javax.swing.GroupLayout(panelController);
        panelController.setLayout(panelControllerLayout);
        panelControllerLayout.setHorizontalGroup(
            panelControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 944, Short.MAX_VALUE)
        );
        panelControllerLayout.setVerticalGroup(
            panelControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 82));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Admin");

        lblRole.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setText("admin");

        btnLogout.setBorder(null);
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        btnLogout.setBorderColor(new java.awt.Color(0, 204, 51));
        btnLogout.setRadius(10);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRole)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelController, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelController, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Bạn thực sự muốn đăng xuất?");
        if (option == JOptionPane.YES_OPTION) {
            LoginForm login = new LoginForm();
            this.dispose();
            login.setVisible(rootPaneCheckingEnabled);
        }

    }//GEN-LAST:event_btnLogoutActionPerformed

 
//    public static void main(String args[]) {
// 
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Home().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom13.swingCustom.ButtonCustom btnLogout;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel panelController;
    private javax.swing.JPanel pnMenu;
    // End of variables declaration//GEN-END:variables
}
