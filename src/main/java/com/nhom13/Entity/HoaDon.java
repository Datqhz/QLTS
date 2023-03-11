package com.nhom13.Entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class HoaDon {
   private int soHoaDon ;
   private String hinhThucThanhToan ;
   private String ngayLap ;
   private float thanhTien;
   private int idKm ;
   private String maNv ;
   private int idKh ;
   List<Ban> listBan;

    public HoaDon(int soHoaDon, String hinhThucThanhToan, String ngayLap, float thanhTien, int idKm, String maNv, int idKh) {
        this.soHoaDon = soHoaDon;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ngayLap = ngayLap;
        this.thanhTien = thanhTien;
        this.idKm = idKm;
        this.maNv = maNv;
        this.idKh = idKh;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getIdKm() {
        return idKm;
    }

    public void setIdKm(int idKm) {
        this.idKm = idKm;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public int getIdKh() {
        return idKh;
    }

    public void setIdKh(int idKh) {
        this.idKh = idKh;
    }

    public List<Ban> getListBan() {
        return listBan;
    }

    public void setListBan(List<Ban> listBan) {
        this.listBan = listBan;
    }

    public HoaDon() {
    }
    
   
}