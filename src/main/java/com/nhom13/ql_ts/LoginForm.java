package com.nhom13.ql_ts;

import com.nhom13.DAO.EmployeeDAO;
import com.nhom13.DAO.TaiKhoanDAO;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.TaiKhoan;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    private TaiKhoan account;
    private Employee emp;
    private Home home;

    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public TaiKhoan getAccount() {
        return account;
    }

    public void setAccount(TaiKhoan account) {
        this.account = account;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public void getInfoLogin() {

    }

    // Kiểm tra trạng thái đăng nhập
    public boolean checkLogin() {
        emp = null;
        try {
            TaiKhoanDAO dao = new TaiKhoanDAO();
            account = dao.findByAccount(txtUsername.getText().trim(), new String(txtPassword.getPassword()).trim());
            if (account != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(account.toString());
        return false;
    }

    // Kiểm tra kí tự đặc biệt
    public static boolean isContainSpecialWord(String s) {
        Pattern VALID_INPUT_REGEX = Pattern.compile("[$&+,:;=\\\\\\\\?@#|/'<>.^*()%!-]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_INPUT_REGEX.matcher(s);
        return matcher.find();
    }

    public void Login() {
        boolean check = true;

        if (txtUsername.getText().isEmpty()) {
            lblError.setText("Please enter your username");
            check = false;
        } else if (isContainSpecialWord(txtUsername.getText())) {
            lblError.setText("Username must not contain special character");
            check = false;
        } else if (txtUsername.getText().contains(" ")) {
            lblError.setText("Username must not contain space.");
            check = false;
        }

        if (new String(txtPassword.getPassword()).isEmpty()) {
            lblError.setText("Please enter your password");
            check = false;
        } else if (new String(txtPassword.getPassword()).contains(" ")) {
            lblError.setText("Password must not contain space");
            check = false;
        }
        if (check) {
            if (checkLogin()) {
                if (!account.isTrangThai()) {
                    JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị khóa. Vui lòng liên hệ quản trị viên để biết thêm chi tiết.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        EmployeeDAO dao = new EmployeeDAO();
                        emp=dao.findEmployeeByAccount(account.getTenTk());
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    emp.setAccount(account);
                    home = new Home(emp);
                    this.dispose();
                    home.setTitle("Quản lí quán trà sữa");
                    home.setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblForgot = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        btnLogin = new com.nhom13.swingCustom.ButtonCustom();
        lblNoAccount = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblBackground = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtUsername.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Password");

        lblForgot.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblForgot.setForeground(new java.awt.Color(51, 51, 255));
        lblForgot.setText("Forgot password?");
        lblForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotMouseClicked(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setText("  ");

        btnLogin.setBackground(new java.awt.Color(51, 204, 0));
        btnLogin.setBorder(null);
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Sign In");
        btnLogin.setBorderColor(new java.awt.Color(255, 255, 255));
        btnLogin.setColor(new java.awt.Color(51, 204, 0));
        btnLogin.setColorOver(new java.awt.Color(0, 204, 102));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setRadius(15);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });

        lblNoAccount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNoAccount.setForeground(new java.awt.Color(51, 102, 255));
        lblNoAccount.setText("Sign up");
        lblNoAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNoAccountMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milkTea (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Welcome Back");

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Don't have an account?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(270, 270, 270))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNoAccount)
                                .addGap(127, 127, 127))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblForgot)))
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblForgot)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoAccount)
                    .addComponent(jLabel1))
                .addGap(77, 77, 77))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Login();

    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblForgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotMouseClicked
        JOptionPane.showMessageDialog(this, "Tính năng này chưa được hỗ trợ.", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_lblForgotMouseClicked

    private void lblNoAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNoAccountMouseClicked
        JOptionPane.showMessageDialog(this, "Vui lòng liên hệ với quản lí để đăng kí tài khoản.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblNoAccountMouseClicked

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Login();
        }
    }//GEN-LAST:event_btnLoginKeyPressed

//    public static void main(String args[]) {
// 
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LoginForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom13.swingCustom.ButtonCustom btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblForgot;
    private javax.swing.JLabel lblNoAccount;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
