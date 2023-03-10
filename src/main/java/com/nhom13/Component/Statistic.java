package com.nhom13.Component;

import com.nhom13.DAO.DoanhThuDAO;
import com.nhom13.Entity.DoanhThuTheoMonAn;
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
    public DoanhThuDAO dao = new DoanhThuDAO();
    public List<DoanhThuTheoMonAn> doanhThu = new ArrayList<>();

    public Statistic() {

        initComponents();
        panelChart.setLayout(new FlowLayout());
        setStatistic();
    }

    public static JFreeChart createChart(String date, List<DoanhThuTheoMonAn> doanhThu) {//List<DoanhThuTheoMonAn> list

        JFreeChart barChart = ChartFactory.createBarChart(
                "TOP 5 MÓN CÓ DOANH THU CAO NHẤT",
                "Doanh thu", "Món",
                createDataset(date, doanhThu), PlotOrientation.VERTICAL, false, false, false
        );
        return barChart;
    }

    public static CategoryDataset createDataset(String date, List<DoanhThuTheoMonAn> list) {//List<DoanhThuTheoMonAn> list

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (DoanhThuTheoMonAn temp : list) {
            dataset.addValue(temp.getTongTien(), "Doanh thu", temp.getTenMon());
        }

//        dataset.addValue(doanhThu.get(0).getTongTien(), "Doanh thu", doanhThu.get(0).getTenMon());
//        dataset.addValue(doanhThu.get(1).getTongTien(), "Doanh thu", doanhThu.get(1).getTenMon());
//        dataset.addValue(doanhThu.get(2).getTongTien(), "Doanh thu", doanhThu.get(2).getTenMon());
//        dataset.addValue(doanhThu.get(3).getTongTien(), "Doanh thu", doanhThu.get(3).getTenMon());
//        dataset.addValue(doanhThu.get(4).getTongTien(), "Doanh thu", doanhThu.get(4).getTenMon());
        return dataset;
    }

    public void setStatistic() {
        String Month = String.valueOf(this.month.getMonth());
        String Year = String.valueOf(this.year.getYear());
        String date = Month.concat("-").concat(Year);
        doanhThu = dao.topDoanhThu5MonAnTheoThoiGian(date);
        cardBill.setData("Hóa đơn", getTongSoHoaDon(date), "/bill_white.png");
        cardProfit.setData("Doanh thu", getTongDoanhThuTheoNgay(date), "/coin_white.png");
        cardEmployee.setData("Nhân viên", getSoLuongNhanVien(), "/employee_white.png");
        cardClient.setData("Khách hàng", getSoLuongKhachHang(), "/client_white.png");

        panelChart.removeAll();
        ChartPanel chart = new ChartPanel(createChart(date, doanhThu));
        chart.setPreferredSize(new java.awt.Dimension(580, 400));
        panelChart.add(chart);
    }

    public void setStatistic(int bill, int profit, int employee, int client, String date) {
        doanhThu = dao.topDoanhThu5MonAnTheoThoiGian(date);
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

    public int getTongSoHoaDon(String date) {
        return dao.soLuongHoaDon(date);
    }

    public int getTongDoanhThuTheoNgay(String date) {
        return dao.tongDoanhThuCuaNgay(date);
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
        year = new com.toedter.calendar.JYearChooser();
        month = new com.toedter.calendar.JMonthChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Thời gian");

        search.setText("Tìm kiếm");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addContainerGap(21, Short.MAX_VALUE)
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
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(month, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(year, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(search, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
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
        String Month = String.valueOf(this.month.getMonth() + 1);
        String Year = String.valueOf(this.year.getYear());
        String date = Month.concat("-").concat(Year);
        int bill = getTongSoHoaDon(date);
        int profit = getTongDoanhThuTheoNgay(date);
        int employee = getSoLuongNhanVien();
        int client = getSoLuongKhachHang();
        System.out.println(date);
        setStatistic(bill, profit, employee, client, date);

    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom13.swingCustom.Card cardBill;
    private com.nhom13.swingCustom.Card cardClient;
    private com.nhom13.swingCustom.Card cardEmployee;
    private com.nhom13.swingCustom.Card cardProfit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JMonthChooser month;
    private javax.swing.JPanel panelChart;
    private javax.swing.JButton search;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables
}
