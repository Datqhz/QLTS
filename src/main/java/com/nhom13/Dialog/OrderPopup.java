package com.nhom13.Dialog;

import com.nhom13.Component.CategoryItem;
import com.nhom13.Component.FoodItem;
import com.nhom13.DAO.BanDAO;
import com.nhom13.DAO.CTBanDAO;
import com.nhom13.DAO.HoaDonDao;
import com.nhom13.DAO.KhuyenMaiDAO;
import com.nhom13.DAO.LoaiMonDao;
import com.nhom13.DAO.MonAnDAO;
import com.nhom13.Entity.Ban;
import com.nhom13.Entity.ChiTietBan;
import com.nhom13.Entity.ChiTietHoaDon;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.HoaDon;
import com.nhom13.Entity.KhuyenMai;
import com.nhom13.Entity.LoaiMon;
import com.nhom13.Entity.MonAn;
import com.nhom13.swingCustom.ScrollBarCustom;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baam0
 */
public class OrderPopup extends javax.swing.JFrame {

    KhuyenMai sale;
    List<ChiTietHoaDon> foodChoosedList = new ArrayList<>();
    List<MonAn> foodList = new ArrayList<>();
    List<LoaiMon> categoryList = new ArrayList<>();
    List<Ban> banList = new ArrayList<>();
    DefaultTableModel tblModel = new DefaultTableModel();
    private Employee nv;
    private boolean status;

    public OrderPopup(Employee nv) {
        initComponents();
        setLocationRelativeTo(null);
        panelFood.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelFood.setPreferredSize(new Dimension(628, 642));
        panelFood.setMaximumSize(new Dimension(628, 642));
        panelFood.setMinimumSize(new Dimension(628, 642));
        panelCategory.setLayout(new BoxLayout(panelCategory, BoxLayout.Y_AXIS));
        tblChoosed.setModel(tblModel);
        tblModel.setColumnIdentifiers(new Object[]{"Món", "Số lượng", "Giá", "Tổng"});
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        this.nv = nv;
        setBillInfo();
        lblTotal.setText("");
        lblDiscountM.setText("");
        lblAmount.setText("");
        loadCategory();
        loadFoodItem();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setSale() {
        try {
            KhuyenMaiDAO dao = new KhuyenMaiDAO();
            sale = dao.getKMInTime();
            if (sale == null) {
                sale = new KhuyenMai();
                sale.setGiaTri(0);
            }
            lblSale.setText(sale.getGiaTri() + "%");
        } catch (Exception e) {
            System.out.println("Lấy khuyến mãi không thành công");
        }
    }

    public void loadCategory() {
        try {
            LoaiMonDao loaiMonDao = new LoaiMonDao();
            categoryList = loaiMonDao.findAll();
            for (LoaiMon category : categoryList) {
                CategoryItem tmp = new CategoryItem(category);
                AddListenerCategoryItem(tmp);
                panelCategory.add(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddListenerCategoryItem(CategoryItem item) {
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getFood(item.getCategory().getId());
                loadFoodItem();
            }
        }
        );
    }

    public boolean getBanTrong() {
        cbxTable.removeAllItems();
        try {
            BanDAO dao = new BanDAO();
            banList = dao.searchTenBanAvailable();
            if (!banList.isEmpty()) {
                for (Ban ban : banList) {
                    cbxTable.addItem(ban.getTenBan());
                    cbxTable.setSelectedIndex(-1);
                }
                return true;
            } else {

                return false;
            }
        } catch (Exception e) {
            System.out.println("Lấy bàn trống không thành công");
        }
        return false;
    }

    public void setBillInfo() {
        lblCreateDay.setText(java.time.LocalDate.now().toString());
        cbxDung.removeAllItems();
        cbxDung.addItem("Tại quán");
        cbxDung.addItem("Mang về");
        cbxDung.setSelectedIndex(-1);
        cbxTT.removeAllItems();
        cbxTT.addItem("Tiền mặt");
        cbxTT.addItem("Chuyển khoản");
        lblEmpName.setText(nv.getFirstName() + " " + nv.getLastName());
//        lblEmpName.setText(nv);
        setSale();
        cbxTable.setEnabled(false);

    }

    public int checkExist(int mamon) {
        int index = 0;
        for (ChiTietHoaDon ct : foodChoosedList) {
            if (ct.getIdMonAn() == mamon) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public String NumberVN(double s) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        return vn.format(s);
    }

    public void UpdateAmount() {
        double total = 0;
        for (ChiTietHoaDon tmp : foodChoosedList) {
            total += tmp.getGia() * tmp.getSoLuong();
        }
        double discount = total * sale.getGiaTri() / 100;
        lblTotal.setText(NumberVN(total));
        lblDiscountM.setText(NumberVN(discount));
        lblAmount.setText(NumberVN(total - discount));
    }

    public double countBill() {
        double total = 0;
        for (ChiTietHoaDon tmp : foodChoosedList) {
            tmp.setGia((tmp.getGia() * (100 - sale.getGiaTri())) / 100);
            total += tmp.getGia() * tmp.getSoLuong();
        }
        return total;
    }

    public void addListenerFoodItem(FoodItem... items) {
        for (FoodItem item : items) {
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    SubFood sub = new SubFood();
                    sub.setFeature(Feature.ADD);
                    sub.setVisible(true);
                    if (sub.isStatus()) {
                        int index = checkExist(item.getFood().getId());
                        if (index == -1) {
                            MonAn food = item.getFood();
                            foodChoosedList.add(new ChiTietHoaDon(item.getFood().getId(), sub.getSl(), item.getFood().getGia()));
                            Object[] row = new Object[]{item.getFood().getTenMon(), sub.getSl(), NumberVN(item.getFood().getGia()), NumberVN(sub.getSl() * item.getFood().getGia())};
                            tblModel.addRow(row);

                        } else {
                            foodChoosedList.get(index).setSoLuong(sub.getSl() + foodChoosedList.get(index).getSoLuong());
                            tblModel.setValueAt(foodChoosedList.get(index).getSoLuong(), index, 1);
                            tblModel.setValueAt(NumberVN(foodChoosedList.get(index).getSoLuong() * foodChoosedList.get(index).getGia()), index, 3);

                        }
                        UpdateAmount();
                    }
                }
            }
            );
        }

    }

    public void getFood(int id) {
        try {
            MonAnDAO monAnDAO = new MonAnDAO();
            LoaiMonDao loaiMonDao = new LoaiMonDao();
            foodList = monAnDAO.findByCategory(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFoodItem() {
        panelFood.removeAll();
        for (MonAn food : foodList) {
            FoodItem fooditem = new FoodItem(food);
            addListenerFoodItem(fooditem);
            panelFood.add(fooditem);
        }
        panelFood.repaint();
        panelFood.revalidate();
    }

    public boolean checkChoose() {
        if (cbxDung.getSelectedIndex() == 0) {
            if (cbxTable.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Vui lòng chọn bàn.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } else if (cbxDung.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(new java.awt.Frame(), "Vui lòng chọn phương thức sử dụng.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (cbxTT.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(new java.awt.Frame(), "Vui lòng chọn phương thức thanh toán.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (foodChoosedList.isEmpty()) {
            JOptionPane.showMessageDialog(new java.awt.Frame(), "Vui lòng chọn món.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public HoaDon getInfoOrder() {
        HoaDon bill = new HoaDon();
        bill.setHinhThucThanhToan(cbxTT.getSelectedItem().toString());
        if (cbxDung.getSelectedItem().equals("Tại quán")) {
            bill.setIdBan(banList.get(cbxTable.getSelectedIndex()).getId());
        }
        if (!lblIDClient.getText().isBlank()) {
            bill.setIdKhachHang(Integer.parseInt(lblIDClient.getText()));
        }
        bill.setIdNhanVien(nv.getMaNV());
        if (sale != null) {
            bill.setIdKhuyenMai(sale.getId());
        }
        bill.setThanhTien(countBill());
        bill.setFoodList(foodChoosedList);
        return bill;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblEmpName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxDung = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxTable = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblSale = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblCreateDay = new javax.swing.JLabel();
        cbxTT = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblDiscountM = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnPrint = new com.nhom13.swingCustom.ButtonCustom();
        btnReset = new com.nhom13.swingCustom.ButtonCustom();
        btnClose = new com.nhom13.swingCustom.ButtonCustom();
        btnChooseClient = new com.nhom13.swingCustom.ButtonCustom();
        lblIDClient = new javax.swing.JLabel();
        panelChoosed = new javax.swing.JPanel();
        btnEdit = new com.nhom13.swingCustom.ButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChoosed = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelFood = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelCategory = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelInfo.setBackground(new java.awt.Color(255, 255, 255));
        panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("ID  khách hàng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Ngày tạo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Người tạo:");

        lblEmpName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblEmpName.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpName.setText("Hồ Quốc Đạt");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Dùng:");

        cbxDung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDung.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDungItemStateChanged(evt);
            }
        });
        cbxDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxDungMouseClicked(evt);
            }
        });
        cbxDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDungActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setText("Bàn:");

        cbxTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setText("Thanh toán:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setText("Khuyến mãi:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setText("Tổng:");

        lblSale.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblSale.setText("100%");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("1000000");

        lblCreateDay.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblCreateDay.setText("22/2/2023");

        cbxTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setText("Giảm giá:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setText("Thành tiền:");

        lblAmount.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 0, 0));
        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmount.setText("0");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel19.setText("VND");

        lblDiscountM.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblDiscountM.setForeground(new java.awt.Color(255, 0, 0));
        lblDiscountM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiscountM.setText("1000000");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel22.setText("VND");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel21.setText("VND");

        btnPrint.setBorder(null);
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/printer_white.png"))); // NOI18N
        btnPrint.setText("In");
        btnPrint.setBorderColor(new java.awt.Color(255, 255, 255));
        btnPrint.setColor(new java.awt.Color(0, 0, 204));
        btnPrint.setColorClick(new java.awt.Color(0, 0, 153));
        btnPrint.setColorOver(new java.awt.Color(0, 255, 255));
        btnPrint.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPrint.setRadius(10);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnReset.setBorder(null);
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync_white.png"))); // NOI18N
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
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close_white.png"))); // NOI18N
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

        btnChooseClient.setBorder(null);
        btnChooseClient.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseClient.setText("Chọn");
        btnChooseClient.setBorderColor(new java.awt.Color(255, 255, 255));
        btnChooseClient.setColor(new java.awt.Color(0, 0, 204));
        btnChooseClient.setColorClick(new java.awt.Color(0, 0, 153));
        btnChooseClient.setColorOver(new java.awt.Color(0, 255, 255));
        btnChooseClient.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChooseClient.setRadius(10);
        btnChooseClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseClientActionPerformed(evt);
            }
        });

        lblIDClient.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIDClient.setForeground(new java.awt.Color(0, 0, 102));
        lblIDClient.setMaximumSize(new java.awt.Dimension(50, 18));
        lblIDClient.setMinimumSize(new java.awt.Dimension(50, 18));
        lblIDClient.setPreferredSize(new java.awt.Dimension(50, 18));
        lblIDClient.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInfoLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDiscountM, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(panelInfoLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(0, 0, 0)
                                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19))
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))))
                        .addGap(27, 27, 27))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, 0)
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmpName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelInfoLayout.createSequentialGroup()
                                        .addComponent(lblCreateDay, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInfoLayout.createSequentialGroup()
                                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxTable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxDung, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(panelInfoLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSale)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelInfoLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxTT, 0, 131, Short.MAX_VALUE)))
                                .addGap(78, 78, 78))
                            .addGroup(panelInfoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIDClient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChooseClient, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))))))
            .addComponent(jSeparator2)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIDClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChooseClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblCreateDay)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblEmpName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cbxTable, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbxTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblSale))
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTotal)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(lblDiscountM)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblAmount)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        panelChoosed.setBackground(new java.awt.Color(255, 255, 255));
        panelChoosed.setMaximumSize(new java.awt.Dimension(417, 600));
        panelChoosed.setMinimumSize(new java.awt.Dimension(417, 600));

        btnEdit.setBorder(null);
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_white.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setBorderColor(new java.awt.Color(255, 255, 255));
        btnEdit.setColor(new java.awt.Color(0, 0, 204));
        btnEdit.setColorClick(new java.awt.Color(0, 0, 153));
        btnEdit.setColorOver(new java.awt.Color(0, 255, 255));
        btnEdit.setEnabled(false);
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setRadius(10);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        tblChoosed.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblChoosed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblChoosed.setRowHeight(30);
        tblChoosed.setSelectionBackground(new java.awt.Color(0, 0, 255));
        tblChoosed.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblChoosed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChoosedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChoosed);

        jLabel6.setBackground(new java.awt.Color(255, 255, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Đã chọn");
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout panelChoosedLayout = new javax.swing.GroupLayout(panelChoosed);
        panelChoosed.setLayout(panelChoosedLayout);
        panelChoosedLayout.setHorizontalGroup(
            panelChoosedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChoosedLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelChoosedLayout.setVerticalGroup(
            panelChoosedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChoosedLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelFood.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelFoodLayout = new javax.swing.GroupLayout(panelFood);
        panelFood.setLayout(panelFoodLayout);
        panelFoodLayout.setHorizontalGroup(
            panelFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        panelFoodLayout.setVerticalGroup(
            panelFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(panelFood);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelCategory.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCategoryLayout = new javax.swing.GroupLayout(panelCategory);
        panelCategory.setLayout(panelCategoryLayout);
        panelCategoryLayout.setHorizontalGroup(
            panelCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );
        panelCategoryLayout.setVerticalGroup(
            panelCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelCategory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelChoosed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelChoosed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDungActionPerformed

    }//GEN-LAST:event_cbxDungActionPerformed

    private void cbxDungItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDungItemStateChanged
        if (cbxDung.getSelectedIndex() == 0) {
            if (getBanTrong()) {
                cbxTable.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(new java.awt.Frame(), "Hiện tại không còn bàn trống.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                cbxDung.setSelectedIndex(-1);
            }

        } else {
            cbxTable.setSelectedIndex(-1);
            cbxTable.setEnabled(false);
        }
    }//GEN-LAST:event_cbxDungItemStateChanged

    private void tblChoosedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChoosedMouseClicked

        int row = tblChoosed.getSelectedRow();
        if (row >= 0) {
            btnEdit.setEnabled(true);
            System.out.println(row);
            System.out.println(foodChoosedList.get(row));
        }

    }//GEN-LAST:event_tblChoosedMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblChoosed.getSelectedRow();
        if (row >= 0) {
            SubFood sub = new SubFood();
            sub.setFeature(Feature.EDIT);
            sub.setVisible(true);
            if (sub.isStatus()) {
                if (sub.getSl() == 0) {
                    tblModel.removeRow(row);
                    foodChoosedList.remove(row);
                    btnEdit.setEnabled(false);
                } else {
                    foodChoosedList.get(row).setSoLuong(sub.getSl());
                    tblModel.setValueAt(sub.getSl(), row, 1);
                    tblModel.setValueAt(NumberVN(sub.getSl() * foodChoosedList.get(row).getGia()), row, 3);
                    foodChoosedList.get(row).setSoLuong(sub.getSl());
                    btnEdit.setEnabled(false);
                }
            }
            UpdateAmount();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        foodChoosedList = new ArrayList<>();
        tblModel.setRowCount(0);
        cbxDung.setSelectedIndex(-1);
        cbxTable.setSelectedIndex(-1);
        cbxTT.setSelectedIndex(-1);
        lblTotal.setText("");
        lblDiscountM.setText("");
        lblAmount.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        if (checkChoose()) {
            try {

                HoaDonDao dao = new HoaDonDao();
                HoaDon bill = getInfoOrder();
                dao.save(bill);
                if (bill.getIdBan() > 0) {
                    CTBanDAO ctbanDao = new CTBanDAO();
                    ctbanDao.save(new ChiTietBan(false, bill.getIdBan(), nv.getMaNV()));
                    BanDAO banDAO = new BanDAO();
                    Ban ban = banList.get(cbxTable.getSelectedIndex());
                    ban.setTrangThai(true);
                    banDAO.update(ban);

                }
                status = true;
                setVisible(false);
            } catch (Exception e) {
                System.out.println("Thêm hóa đơn không thành công");
                e.printStackTrace();

            }
        }
//        System.out.println(countBill());
//        System.out.println(foodChoosedList);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnChooseClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseClientActionPerformed
        ChooseClientPopup choose = new ChooseClientPopup(this);
        choose.setVisible(true);
        if (choose.isStatus()) {
            lblIDClient.setText(Integer.toString(choose.getClient().getId()));
        }
    }//GEN-LAST:event_btnChooseClientActionPerformed

    private void cbxDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxDungMouseClicked

    }//GEN-LAST:event_cbxDungMouseClicked

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
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(OrderPopup.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(OrderPopup.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(OrderPopup.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(OrderPopup.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new OrderPopup(new Employee("NV05", "Ho", "DAt","adas","sdss","fdsfsf",1,true,"nam")).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom13.swingCustom.ButtonCustom btnChooseClient;
    private com.nhom13.swingCustom.ButtonCustom btnClose;
    private com.nhom13.swingCustom.ButtonCustom btnEdit;
    private com.nhom13.swingCustom.ButtonCustom btnPrint;
    private com.nhom13.swingCustom.ButtonCustom btnReset;
    private javax.swing.JComboBox<String> cbxDung;
    private javax.swing.JComboBox<String> cbxTT;
    private javax.swing.JComboBox<String> cbxTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCreateDay;
    private javax.swing.JLabel lblDiscountM;
    private javax.swing.JLabel lblEmpName;
    private javax.swing.JLabel lblIDClient;
    private javax.swing.JLabel lblSale;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelCategory;
    private javax.swing.JPanel panelChoosed;
    private javax.swing.JPanel panelFood;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JTable tblChoosed;
    // End of variables declaration//GEN-END:variables
}
