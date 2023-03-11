package com.nhom13.Dialog;

import com.nhom13.DAO.LoaiMonDao;
import com.nhom13.DAO.MonAnDAO;
import com.nhom13.Entity.CTSP;
import com.nhom13.Entity.LoaiMon;
import com.nhom13.Entity.MonAn;
import com.nhom13.Support.CharFilterAlphabet;
import com.nhom13.Support.CharFilterNumber;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class FoodPopup extends javax.swing.JDialog {

    private String maNV;
    private boolean status;
    Feature feature;
    private MonAn monAn;
    List<LoaiMon> listCategory;
    DefaultComboBoxModel modelcbx = new DefaultComboBoxModel();

    public FoodPopup(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Thêm món.");
        cbxCategory.setModel(modelcbx);
        AbstractDocument document1 = (AbstractDocument) txtUnit.getDocument();
        document1.setDocumentFilter(new CharFilterAlphabet());
        AbstractDocument document3 = (AbstractDocument) txtPriceSizeM.getDocument();
        document3.setDocumentFilter(new CharFilterNumber());
        AbstractDocument document2 = (AbstractDocument) txtFoodName.getDocument();
        document2.setDocumentFilter(new CharFilterAlphabet());
        AbstractDocument document4 = (AbstractDocument) txtPriceSizeL.getDocument();
        document4.setDocumentFilter(new CharFilterNumber());
        AbstractDocument document5 = (AbstractDocument) txtPriceSizeXL.getDocument();
        document5.setDocumentFilter(new CharFilterNumber());
        
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void resetForm() {
        txtFoodName.setText("");
        txtUnit.setText("");
        txtPriceSizeM.setText("");
        txtPriceSizeL.setText("");
        txtPriceSizeXL.setText("");
        txtImgPath.setText("");
        txtNote.setText("");
        cbxCategory.setSelectedItem(null);
        lblReviewImg.setIcon(null);
    }

    public void loadCombobox() {
        try {
            LoaiMonDao dao = new LoaiMonDao();
            listCategory = dao.findAll();
        } catch (Exception e) {
            System.out.println("load category fail");
        }
    }

    public void setItemCombobox() {
        loadCombobox();
        modelcbx.removeAllElements();
        for (LoaiMon category : listCategory) {

            modelcbx.addElement(category.getTen());
        }

    }

    public void setPriceSize(List<CTSP> list) {
        for (CTSP ct : list) {
            switch (ct.getIdSize()) {
                case 1:
                    txtPriceSizeM.setText(Integer.toString(ct.getGia()));
                    break;
                case 2:
                    txtPriceSizeL.setText(Integer.toString(ct.getGia()));
                    break;
                default:
                    txtPriceSizeXL.setText(Integer.toString(ct.getGia()));
            }
        }
    }

    public void setFeature(Feature f, MonAn ma) {
        setItemCombobox();
        status = false;
        feature = f;
        if (feature == Feature.ADD) {
            txtFoodName.setEnabled(true);
            btnFeature.setText("ADD");
            resetForm();
            this.monAn = null;
        } else {
            txtFoodName.setEnabled(false);
            btnFeature.setText("EDIT");
            this.monAn = ma;
            txtFoodName.setText(ma.getTenMon());
            txtUnit.setText(ma.getDonVi());
            lblReviewImg.setIcon(Resize(ma.getAnh(), 180, 180));
            txtImgPath.setText(ma.getAnh());
            txtNote.setText(ma.getMoTa());
            List<CTSP> listCT = null;
            try {
                MonAnDAO dao = new MonAnDAO();
                listCT = dao.findCTSP(ma.getId());
                setPriceSize(listCT);
            } catch (Exception e) {
                e.printStackTrace();
            }

            LoaiMon loaiMon = listCategory.stream().filter(l -> l.getId() == ma.getIdLoaiMon()).findFirst().orElse(null);
            cbxCategory.setSelectedItem(loaiMon.getTen());

        }
    }

    public boolean check(String m) {
        return m.length() == 0 || m == null;
    }

    public Icon Resize(String path, int k, int m) {
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(k, m, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }

    public boolean checkFoodName(String name) {
        try {
            MonAnDAO dao = new MonAnDAO();
            MonAn temp = dao.findMonAnByName(name.toUpperCase());
            if (temp != null) {
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

        SizeL = new javax.swing.JPanel();
        txtFoodName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPriceSizeM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtImgPath = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        cbxCategory = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnChooseImg = new com.nhom13.swingCustom.ButtonCustom();
        jLabel9 = new javax.swing.JLabel();
        btnFeature = new com.nhom13.swingCustom.ButtonCustom();
        btnReset = new com.nhom13.swingCustom.ButtonCustom();
        btnClose = new com.nhom13.swingCustom.ButtonCustom();
        lblReviewImg = new javax.swing.JLabel();
        txtPriceSizeL = new javax.swing.JTextField();
        txtPriceSizeXL = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        SizeL.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Tên món");

        txtUnit.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Đơn vị tính");

        txtPriceSizeM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceSizeMActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Giá");

        txtImgPath.setEditable(false);
        txtImgPath.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Ảnh");

        txtNote.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        cbxCategory.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Mô tả");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Loại món");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        btnChooseImg.setBorder(null);
        btnChooseImg.setForeground(new java.awt.Color(0, 0, 102));
        btnChooseImg.setText("Chọn ảnh");
        btnChooseImg.setBorderColor(new java.awt.Color(0, 0, 204));
        btnChooseImg.setColorClick(new java.awt.Color(0, 0, 153));
        btnChooseImg.setColorOver(new java.awt.Color(0, 255, 255));
        btnChooseImg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChooseImg.setRadius(10);
        btnChooseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImgActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

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

        btnReset.setBorder(null);
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Làm mới");
        btnReset.setBorderColor(new java.awt.Color(255, 255, 255));
        btnReset.setColor(new java.awt.Color(0, 0, 204));
        btnReset.setColorClick(new java.awt.Color(0, 0, 153));
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
        btnClose.setColorClick(new java.awt.Color(0, 0, 153));
        btnClose.setColorOver(new java.awt.Color(0, 255, 255));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setRadius(10);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblReviewImg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblReviewImg.setPreferredSize(new java.awt.Dimension(60, 60));

        jLabel10.setText("Size M");

        jLabel11.setText("Size L");

        jLabel12.setText("SizeXL");

        javax.swing.GroupLayout SizeLLayout = new javax.swing.GroupLayout(SizeL);
        SizeL.setLayout(SizeLLayout);
        SizeLLayout.setHorizontalGroup(
            SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SizeLLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblReviewImg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(SizeLLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SizeLLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(txtImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChooseImg, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SizeLLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SizeLLayout.createSequentialGroup()
                                .addComponent(txtPriceSizeM)
                                .addGap(18, 18, 18)
                                .addComponent(txtPriceSizeL, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPriceSizeXL, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(SizeLLayout.createSequentialGroup()
                                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(SizeLLayout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71))
                            .addGroup(SizeLLayout.createSequentialGroup()
                                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SizeLLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(SizeLLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(SizeLLayout.createSequentialGroup()
                        .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SizeLLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SizeLLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SizeLLayout.createSequentialGroup()
                                .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );
        SizeLLayout.setVerticalGroup(
            SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SizeLLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPriceSizeM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPriceSizeL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPriceSizeXL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseImg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(lblReviewImg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SizeLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SizeL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SizeL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImgActionPerformed
        JFileChooser c = new JFileChooser();
        int rs = c.showOpenDialog(this);
        if (rs == JFileChooser.APPROVE_OPTION) {
            txtImgPath.setText(c.getSelectedFile().getAbsolutePath());
            lblReviewImg.setIcon(Resize(c.getSelectedFile().getAbsolutePath(), 180, 180));
        }
    }//GEN-LAST:event_btnChooseImgActionPerformed

    private void btnFeatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeatureActionPerformed
        String name = txtFoodName.getText().trim();
        String donVi = txtUnit.getText().trim();
        String giaM = txtPriceSizeM.getText().trim();
        String giaL = txtPriceSizeL.getText().trim();
        String giaXL = txtPriceSizeXL.getText().trim();
        String moTa = txtNote.getText().trim();
        String imgPath;
        if (check(txtImgPath.getText().trim())) {
            imgPath = "C:\\Users\\baam0\\OneDrive\\Documents\\GitHub\\QL_TS\\src\\main\\resources\\new.png";
        } else {
            imgPath = txtImgPath.getText();
        }
        String tenLoai = "";
        if (cbxCategory.getSelectedItem() != null) {
            tenLoai = cbxCategory.getSelectedItem().toString();
        }
        if (check(name) || check(giaM) || check(giaL) || check(giaXL) || check(tenLoai)) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
        }
            else {
            MonAn monAn1 = new MonAn();
            monAn1.setTenMon(name);
            monAn1.setDonVi(donVi);
            monAn1.setMoTa(moTa);
            monAn1.setAnh(imgPath);
            int idLoaiMon = -1;
            for (LoaiMon lm : listCategory) {
                if (lm.getTen().equals(tenLoai)) {
                    idLoaiMon = lm.getId();
                    break;
                }
            }
            monAn1.setIdLoaiMon(idLoaiMon);

            try {
                MonAnDAO dao = new MonAnDAO();
                if (feature == Feature.ADD) {
                    if (checkFoodName(name)) {
                        JOptionPane.showMessageDialog(rootPane, "Tên món đã tồn tại.");
                    } else {
                        dao.save(monAn1);
                        int idmon = dao.getId();
                        dao.saveCTSP(1, idmon, Integer.parseInt(giaM));
                        dao.saveCTSP(2, idmon, Integer.parseInt(giaL));
                        dao.saveCTSP(3, idmon, Integer.parseInt(giaXL));
                        JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
                        status = true;
                        resetForm();
                        setVisible(false);
                    }

                } else {

                    monAn1.setId(monAn.getId());
                    System.out.println(monAn1);
                    dao.updateSanPham(monAn1);
                    dao.updateCtsp(monAn.getId(), 1, Integer.parseInt(giaM));
                    dao.updateCtsp(monAn.getId(), 2, Integer.parseInt(giaL));
                    dao.updateCtsp(monAn.getId(), 3, Integer.parseInt(giaXL));
                    JOptionPane.showMessageDialog(rootPane, "Sửa thành công!");
                    status = true;
                    resetForm();
                    setVisible(false);
                }
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_btnFeatureActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        resetForm();
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtPriceSizeMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceSizeMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceSizeMActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(FoodPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FoodPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FoodPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FoodPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                FoodPopup dialog = new FoodPopup(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel SizeL;
    private com.nhom13.swingCustom.ButtonCustom btnChooseImg;
    private com.nhom13.swingCustom.ButtonCustom btnClose;
    private com.nhom13.swingCustom.ButtonCustom btnFeature;
    private com.nhom13.swingCustom.ButtonCustom btnReset;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblReviewImg;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtImgPath;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtPriceSizeL;
    private javax.swing.JTextField txtPriceSizeM;
    private javax.swing.JTextField txtPriceSizeXL;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
