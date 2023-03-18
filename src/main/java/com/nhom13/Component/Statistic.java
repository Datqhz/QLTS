package com.nhom13.Component;

import com.nhom13.DAO.DoanhThuDAO;
import com.nhom13.Entity.DoanhThuTheoMonAn;
import com.toedter.calendar.*;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Statistic extends javax.swing.JPanel {

    /**
     * Creates new form Statistic
     */
    private JMonthChooser month = new JMonthChooser();
    private JYearChooser year = new JYearChooser();
    JDateChooser dayChoose = new JDateChooser();
    public DoanhThuDAO dao = new DoanhThuDAO();
    public List<DoanhThuTheoMonAn> doanhThu = new ArrayList<>();

    public Statistic() {

        initComponents();
        panelChart.setLayout(new FlowLayout());
        cbxXem.setSelectedIndex(-1);
        search.setEnabled(false);
        cardBill.setData("Hóa đơn", 0, "/bill_white.png");
        cardProfit.setData("Doanh thu", 0, "/coin_white.png");
        cardEmployee.setData("Nhân viên", 0, "/employee_white.png");
        cardClient.setData("Khách hàng", 0, "/client_white.png");
        panelTime.setLayout(new FlowLayout(FlowLayout.LEFT));
        dayChoose.setPreferredSize(new java.awt.Dimension(100, 24));
        month.setPreferredSize(new java.awt.Dimension(125, 24));
        year.setPreferredSize(new java.awt.Dimension(70, 24));
    }

    public static JFreeChart createChart(String date, List<DoanhThuTheoMonAn> doanhThu) {//List<DoanhThuTheoMonAn> list

        JFreeChart barChart = ChartFactory.createBarChart(
                "TOP 5 MÓN CÓ DOANH THU CAO NHẤT",
                "Món", "Doanh thu",
                createDataset(date, doanhThu), PlotOrientation.VERTICAL, false, false, false
        );
        return barChart;
    }

    public static CategoryDataset createDataset(String date, List<DoanhThuTheoMonAn> list) {//List<DoanhThuTheoMonAn> list
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (DoanhThuTheoMonAn temp : list) {
            dataset.addValue(temp.getTongTien(), "Món", temp.getTenMon());
        }
        return dataset;
    }

    public void setStatistic(int bill, int profit, int employee, int client, String date) {
        doanhThu = switch (cbxXem.getSelectedIndex()) {
            case 0 ->
                dao.topDoanhThu5MonAnTheoThoiGian(date, 0);
            case 1 ->
                dao.topDoanhThu5MonAnTheoThoiGian(date, 1);
            default ->
                dao.topDoanhThu5MonAnTheoThoiGian(date, 2);
        };

        cardBill.setData("Hóa đơn", bill, "/bill_white.png");
        cardProfit.setData("Doanh thu", profit, "/coin_white.png");
        cardEmployee.setData("Nhân viên", employee, "/employee_white.png");
        cardClient.setData("Khách hàng", client, "/client_white.png");

        panelChart.removeAll();
        ChartPanel chart = new ChartPanel(createChart(date, doanhThu));
        chart.setPreferredSize(new java.awt.Dimension(580, 400));
        panelChart.add(chart);
        System.out.println(doanhThu);
    }

    public int getTongSoHoaDonNam(String date) {
        return dao.soLuongHoaDonNam(date);
    }

    public int getTongSoHoaDonThang(String date) {
        return dao.soLuongHoaDonThang(date);
    }

    public int getTongSoHoaDonNgay(String date) {
        return dao.soLuongHoaDonNgay(date);
    }

    public int getTongDoanhThuTheoNgay(String date) {
        return dao.tongDoanhThuCuaNgay(date);
    }

    public int getTongDoanhThuTheoThang(String date) {
        return dao.tongDoanhThuCuaThang(date);
    }

    public int getTongDoanhThuTheoNam(String date) {
        return dao.tongDoanhThuCuaNam(date);
    }

    public int getSoLuongNhanVien() {
        return dao.TongSoNhanVien();
    }

    public int getSoLuongKhachHang() {
        return dao.soLuongKhachHang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelChart = new javax.swing.JPanel();
        cardBill = new com.nhom13.swingCustom.Card();
        cardProfit = new com.nhom13.swingCustom.Card();
        cardEmployee = new com.nhom13.swingCustom.Card();
        cardClient = new com.nhom13.swingCustom.Card();
        jPanel2 = new javax.swing.JPanel();
        search = new javax.swing.JButton();
        cbxXem = new javax.swing.JComboBox<>();
        panelTime = new javax.swing.JPanel();

        panelChart.setBackground(new java.awt.Color(255, 255, 255));
        panelChart.setPreferredSize(new java.awt.Dimension(450, 450));

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        cardBill.setBackground(new java.awt.Color(0, 0, 255));
        cardBill.setColorGradient(new java.awt.Color(204, 102, 255));
        cardBill.setMaximumSize(new java.awt.Dimension(153, 112));

        cardProfit.setBackground(new java.awt.Color(255, 0, 0));
        cardProfit.setColorGradient(new java.awt.Color(255, 204, 51));
        cardProfit.setMaximumSize(new java.awt.Dimension(153, 112));

        cardEmployee.setBackground(new java.awt.Color(255, 0, 0));
        cardEmployee.setColorGradient(new java.awt.Color(255, 51, 204));

        cardClient.setBackground(new java.awt.Color(0, 153, 51));
        cardClient.setColorGradient(new java.awt.Color(0, 255, 204));
        cardClient.setMaximumSize(new java.awt.Dimension(153, 112));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        search.setText("Xem");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        cbxXem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm"}));
        cbxXem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxXemItemStateChanged(evt);
            }
        });

        panelTime.setMaximumSize(new java.awt.Dimension(244, 24));
        panelTime.setMinimumSize(new java.awt.Dimension(244, 24));

        javax.swing.GroupLayout panelTimeLayout = new javax.swing.GroupLayout(panelTime);
        panelTime.setLayout(panelTimeLayout);
        panelTimeLayout.setHorizontalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        panelTimeLayout.setVerticalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(cbxXem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cardClient, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cardEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cardProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardBill, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cardBill, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cardProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(cardEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cardClient, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search)
                            .addComponent(cbxXem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        int bill;
        int profit;
        int employee;
        int client;
        String Day;
        String Month;
        String Year;
        String date = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        switch (cbxXem.getSelectedIndex()) {
            case 0 -> {
                Day = dateFormat.format(dayChoose.getDate());
                bill = getTongSoHoaDonNgay(Day);
                profit = getTongDoanhThuTheoNgay(Day);
                date = Day;
            }
            case 1 -> {
                Month = String.valueOf(this.month.getMonth() + 1);
                Year = String.valueOf(this.year.getYear());
                date = Month.concat("-").concat(Year);
                bill = getTongSoHoaDonThang(date);
                profit = getTongDoanhThuTheoThang(date);
            }
            default -> {
                Year = String.valueOf(this.year.getYear());
                bill = getTongSoHoaDonNam(Year);
                profit = getTongDoanhThuTheoNam(Year);
                date = Year;
            }
        }
        employee = getSoLuongNhanVien();
        client = getSoLuongKhachHang();
        setStatistic(bill, profit, employee, client, date);

    }//GEN-LAST:event_searchActionPerformed

    private void cbxXemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxXemItemStateChanged
        if (cbxXem.getSelectedIndex() >= 0) {
            switch (cbxXem.getSelectedIndex()) {
                case 0 -> {
                    panelTime.removeAll();
                    panelTime.add(dayChoose);
                    panelTime.repaint();
                    panelTime.revalidate();
                }
                case 1 -> {
                    panelTime.removeAll();
                    panelTime.add(month);
                    panelTime.add(year);
                    panelTime.repaint();
                    panelTime.revalidate();
                }
                default -> {
                    panelTime.removeAll();
                    panelTime.add(year);
                    panelTime.repaint();
                    panelTime.revalidate();
                }
            }
            search.setEnabled(true);
        }


    }//GEN-LAST:event_cbxXemItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom13.swingCustom.Card cardBill;
    private com.nhom13.swingCustom.Card cardClient;
    private com.nhom13.swingCustom.Card cardEmployee;
    private com.nhom13.swingCustom.Card cardProfit;
    private javax.swing.JComboBox<String> cbxXem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelChart;
    private javax.swing.JPanel panelTime;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
