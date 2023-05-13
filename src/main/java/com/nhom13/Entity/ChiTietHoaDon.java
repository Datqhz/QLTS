package com.nhom13.Entity;

public class ChiTietHoaDon {

    private int soHoaDon ;
    private int idSize ;
    private int idMon ;
    private int soluong;
    private double gia ;
    private String tenmon;

    public ChiTietHoaDon(int soHoaDon, int idSize, int idMon, int soluong, double gia) {
        this.soHoaDon = soHoaDon;
        this.idSize = idSize;
        this.idMon = idMon;
        this.soluong = soluong;
        this.gia = gia;
    }

    public ChiTietHoaDon(int idSize, int idMon, int soluong, double gia) {
        this.idSize = idSize;
        this.idMon = idMon;
        this.soluong = soluong;
        this.gia = gia;
    }

    public ChiTietHoaDon() {
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "soHoaDon=" + soHoaDon + ", idSize=" + idSize + ", idMon=" + idMon + ", soluong=" + soluong + ", gia=" + gia + '}';
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getIdMon() {
        return idMon;
    }

    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
}
