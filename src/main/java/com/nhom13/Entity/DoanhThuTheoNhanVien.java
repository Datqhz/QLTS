/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.Entity;

import java.util.Date;

/**
 *
 * @author thuan
 */
public class DoanhThuTheoNhanVien {

    private String idNhanVien;
    private String hoTen;
    private int soHoaDon;
    private Long tongDoanhThu;

    @Override
    public String toString() {
        return "DoanhThuTheoNhanVien{" + "idNhanVien=" + idNhanVien + ", hoTen=" + hoTen + ", soHoaDon=" + soHoaDon + ", tongDoanhThu=" + tongDoanhThu + '}';
    }

    public DoanhThuTheoNhanVien() {
    }

    public DoanhThuTheoNhanVien(String idNhanVien, String hoTen, int soHoaDon, Long tongDoanhThu) {
        this.idNhanVien = idNhanVien;
        this.hoTen = hoTen;
        this.soHoaDon = soHoaDon;
        this.tongDoanhThu = tongDoanhThu;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public Long getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(Long tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

}
