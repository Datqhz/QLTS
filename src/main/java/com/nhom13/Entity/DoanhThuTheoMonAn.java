
package com.nhom13.Entity;


public class DoanhThuTheoMonAn {
    private int id ;
    private String tenMon ;
    private String ngayLap ;
    private Double tongTien;

    public DoanhThuTheoMonAn(int id, String tenMon, String ngayLap, Double tongTien) {
        this.id = id;
        this.tenMon = tenMon;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public DoanhThuTheoMonAn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    
}
