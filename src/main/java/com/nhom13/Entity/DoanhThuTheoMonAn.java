
package com.nhom13.Entity;


public class DoanhThuTheoMonAn {
    private int id ;
    private String tenMon ;
    private String ngayLap ;
    private float tongTien;

    public DoanhThuTheoMonAn(int id, String tenMon, String ngayLap, float tongTien) {
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

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "DoanhThuTheoMonAn{" + "id=" + id + ", tenMon=" + tenMon + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + '}';
    }
    
}
