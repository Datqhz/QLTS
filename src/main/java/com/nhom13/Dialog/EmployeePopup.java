package com.nhom13.Dialog;

import com.nhom13.Support.UpperCaseFilter;
import com.nhom13.DAO.EmployeeDAO;
import com.nhom13.DAO.TaiKhoanDAO;
import com.nhom13.DAO.VaiTroDAO;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.TaiKhoan;
import com.nhom13.Entity.VaiTro;
import com.nhom13.Support.CharFilterAlphabet;
import com.nhom13.Support.CharFilterNumber;
import static com.nhom13.Support.UpperCaseFilter.convertToUpperCase;
import static com.nhom13.ql_ts.LoginForm.isContainSpecialWord;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class EmployeePopup extends javax.swing.JDialog {

    List<Employee> empList;
    List<TaiKhoan> accountList;
    private boolean status;
//    Employee emp;
    List<VaiTro> roles;
    Feature f;

    public EmployeePopup(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        loadRole();
        getData();
        cbxStatus.addItem("Active");
        cbxStatus.addItem("Disabled");
        AbstractDocument document1 = (AbstractDocument) txtFirstName.getDocument();
        document1.setDocumentFilter(new CharFilterAlphabet());
        AbstractDocument document2 = (AbstractDocument) txtLastName.getDocument();
        document2.setDocumentFilter(new CharFilterAlphabet());
        AbstractDocument document3 = (AbstractDocument) txtPhoneNumber.getDocument();
        document3.setDocumentFilter(new CharFilterNumber());
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

//    public Employee getEmp() {
//        return emp;
//    }
//
//    public void setEmp(Employee emp) {
//        this.emp = emp;
//    }
    public void getData() {
        try {
            EmployeeDAO dao = new EmployeeDAO();
            empList = dao.findAll();
            TaiKhoanDAO tkDao = new TaiKhoanDAO();
            accountList = tkDao.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadRole() {
        try {
            VaiTroDAO dao = new VaiTroDAO();
            roles = dao.findAll();
        } catch (Exception e) {

        }
        for (VaiTro role : roles) {
            cbxRole.addItem(role.getName());
        }

    }

    public boolean checkID(String id) {
        for (Employee emp : empList) {
            if (emp.getMaNV().equals(id.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAccount(String account) {
        for (TaiKhoan ac : accountList) {
            if (ac.getAccount().equals(account)) {
                return true;
            }
        }
        return false;
    }

    public boolean check(String s) {
        return s.equals("");
    }

    public String getSex() {
        if (rbMale.isSelected()) {
            return "Nam";
        } else if (rbFemale.isSelected()) {
            return "Nữ";
        } else {
            return "Khác";
        }
    }

    public void ResetForm() {
        txtID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAccount.setText("");
        txtPassword.setText("");
        txtPhoneNumber.setText("");
        cbxRole.setSelectedIndex(0);
        rbMale.setSelected(true);
        cbxStatus.setSelectedIndex(0);
        getData();
    }

    public void setFeature(Feature f, Employee emp) {
        status = false;
        this.f = f;
        if (f == Feature.EDIT) {

            btnFeature.setText("Sửa");
//            this.emp =  emp;
            txtID.setEnabled(false);
            txtID.setText(emp.getMaNV());
            txtFirstName.setText(emp.getFirstName());
            txtLastName.setText(emp.getLastName());
            txtAccount.setText(emp.getAccount().getTenTk());
            txtAccount.setEnabled(false);
            txtPassword.setText(emp.getAccount().getMk());
            txtPassword.setEnabled(false);
            txtPhoneNumber.setText((emp.getSdt() == null) ? "" : emp.getSdt());
            cbxRole.setSelectedIndex(emp.getRole() - 1);
            cbxRole.setEnabled(false);
            switch (emp.getGioiTinh()) {
                case "Nam":
                    rbMale.setSelected(true);
                    break;
                case "Nữ":
                    rbFemale.setSelected(true);
                    break;
                default:
                    rbAnother.setSelected(true);
            }
            cbxStatus.setSelectedIndex(emp.getAccount().isTrangThai() ? 0 : 1);
        } else {
            btnFeature.setText("Thêm");
            txtID.setEnabled(true);
            txtAccount.setEnabled(true);
            txtPassword.setEnabled(true);
            ResetForm();
                    
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAccount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnFeature = new com.nhom13.swingCustom.ButtonCustom();
        btnReset = new com.nhom13.swingCustom.ButtonCustom();
        btnClose = new com.nhom13.swingCustom.ButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbxRole = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        rbAnother = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Mã nhân viên");

        txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Họ");

        txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLastNameKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Tên");

        txtAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Tên đăng nhập");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Mật khẩu");

        btnFeature.setBorder(null);
        btnFeature.setForeground(new java.awt.Color(255, 255, 255));
        btnFeature.setText("Thêm");
        btnFeature.setBorderColor(new java.awt.Color(255, 255, 255));
        btnFeature.setColor(new java.awt.Color(0, 0, 204));
        btnFeature.setColorClick(new java.awt.Color(0, 51, 255));
        btnFeature.setColorOver(new java.awt.Color(0, 255, 255));
        btnFeature.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFeature.setRadius(10);
        btnFeature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeatureActionPerformed(evt);
            }
        });

        btnReset.setBorder(null);
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Làm mới");
        btnReset.setActionCommand("btnReset");
        btnReset.setBorderColor(new java.awt.Color(255, 255, 255));
        btnReset.setColor(new java.awt.Color(0, 0, 204));
        btnReset.setColorClick(new java.awt.Color(0, 0, 255));
        btnReset.setColorOver(new java.awt.Color(0, 255, 255));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setRadius(10);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnClose.setBorder(null);
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Đóng");
        btnClose.setBorderColor(new java.awt.Color(255, 255, 255));
        btnClose.setColor(new java.awt.Color(0, 0, 204));
        btnClose.setColorClick(new java.awt.Color(0, 0, 255));
        btnClose.setColorOver(new java.awt.Color(0, 255, 255));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setRadius(10);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("Số điện thoại");

        txtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("Chức vụ");

        cbxRole.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxRole.setModel(new javax.swing.DefaultComboBoxModel<>());
        cbxRole.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("Giới tính");

        rbMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbMale);
        rbMale.setSelected(true);
        rbMale.setText("Nam");

        rbFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbFemale);
        rbFemale.setText("Nữ");

        rbAnother.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbAnother);
        rbAnother.setText("Khác");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("Trạng thái tài khoản");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel7))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(0, 0, 0)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel10))
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48)))
                            .addComponent(jLabel15))
                        .addGap(21, 21, 21)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtAccount, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rbMale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbFemale)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbAnother)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbMale)
                        .addComponent(rbFemale)
                        .addComponent(rbAnother)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

    private void btnFeatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeatureActionPerformed
        String manv = txtID.getText().trim();
        String ho = txtFirstName.getText().trim();
        String ten = txtLastName.getText().trim();
        String account = txtAccount.getText();
        String password = txtPassword.getText();
        String sdt = txtPhoneNumber.getText();
        int roleIndex = cbxRole.getSelectedIndex();
        boolean tt = (cbxStatus.getSelectedIndex() == 0);
        String sex = getSex();
        if (f == Feature.ADD) {
            if (check(manv) || check(ho) || check(ten) || check(account) || check(password)) {
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Vui lòng điền đủ thông tin yêu cầu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (checkID(manv)) {
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Mã nhân viên đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                txtID.setText("");
            } else if (checkID(manv)) {
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Tên đăng nhập không được chứa kí tự đặc biệt!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                txtAccount.setText("");
            } else if (isContainSpecialWord(account)) {

            } else if (checkAccount(account)) {
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Tên đăng nhập đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                txtAccount.setText("");
            } else if (password.contains(" ")) {
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Mật khẩu không được chứa khoảng trắng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                txtPassword.setText("");
            } else {
                try {
                    Employee temp = new Employee(manv, ho, ten, sdt, roleIndex + 1, sex);
                    EmployeeDAO dao = new EmployeeDAO();
                    dao.saveEmployee(temp);
                    TaiKhoanDAO tkDao = new TaiKhoanDAO();
                    TaiKhoan acc = new TaiKhoan(account, password, tt, manv);
                    tkDao.save(acc);
                    JOptionPane.showMessageDialog(new java.awt.Frame(), "Thêm nhân viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    status = true;
                    setVisible(false);
                } catch (Exception e) {
                    System.out.println("Thêm không thành công.");
                }
            }
        } else {
            if (check(ho) || check(ten)) {
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Vui lòng điền đủ thông tin yêu cầu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    TaiKhoan tk = new TaiKhoan(account, password, tt, manv);

                    Employee temp = new Employee(manv, ho, ten, sdt, roleIndex + 1, sex);
                    temp.setAccount(tk);
                    EmployeeDAO dao = new EmployeeDAO();
                    dao.updateEmployee(temp);
                    JOptionPane.showMessageDialog(new java.awt.Frame(), "Cập nhật thông tin nhân viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    status = true;
                    setVisible(false);
                } catch (Exception e) {
                    System.out.println("Thêm không thành công.");
                }
            }
            ResetForm();
        }
        
//        System.out.println(roles.get(roleIndex));

    }//GEN-LAST:event_btnFeatureActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        if (f == Feature.ADD) {
            ResetForm();
        } else {
            txtFirstName.setText("");
            txtLastName.setText("");
            txtPhoneNumber.setText("");
            cbxRole.setSelectedIndex(0);
            rbMale.setSelected(true);
        }

    }//GEN-LAST:event_btnResetActionPerformed

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        convertToUpperCase(txtID);
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyReleased
        convertToUpperCase(txtFirstName);
    }//GEN-LAST:event_txtFirstNameKeyReleased

    private void txtLastNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyReleased
        convertToUpperCase(txtLastName);
    }//GEN-LAST:event_txtLastNameKeyReleased

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                EmployeePopup dialog = new EmployeePopup(new javax.swing.JFrame());
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
    private com.nhom13.swingCustom.ButtonCustom btnReset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxRole;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JRadioButton rbAnother;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
