package com.nhom13.Entity;

public class ChiTietHoaDon {

    private int id;
    private int idHoaDon;
    private int idMonAn;
    private String tenMon;
    private int soLuong;
    private double gia;

    public ChiTietHoaDon(int idMonAn, String tenmon, int soLuong, double gia) {
        this.idMonAn = idMonAn;
        this.tenMon = tenmon;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public ChiTietHoaDon(int idMonAn, int soLuong, double gia) {
        this.idMonAn = idMonAn;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public ChiTietHoaDon(int id, int idHoaDon, int idMonAn, int soLuong, double gia) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idMonAn = idMonAn;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public ChiTietHoaDon() {
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "ChiTetHoaDon{" + "id=" + id + ", idHoaDon=" + idHoaDon + ", idMonAn=" + idMonAn + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }

}
