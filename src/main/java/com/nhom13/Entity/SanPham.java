package com.nhom13.Entity;

import java.util.logging.Logger;

/**
 *
 * @author thuan
 */
public class SanPham {
    private int idSanPham ;
    private String ten ;
    private String moTa;
    private String donViTinh ;
    private String tenLoai ;
    private int gia ;
    private String size;

    public SanPham(int idSanPham, String ten, String donViTinh, String tenLoai, int gia, String size) {
        this.idSanPham = idSanPham;
        this.ten = ten;
        this.donViTinh = donViTinh;
        this.tenLoai = tenLoai;
        this.gia = gia;
        this.size=size;
    }

    public SanPham() {
    }
    
    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    public SanPham(int idSanPham, String ten, String moTa, String donViTinh, String tenLoai, int gia) {
        this.idSanPham = idSanPham;
        this.ten = ten;
        this.moTa = moTa;
        this.donViTinh = donViTinh;
        this.tenLoai = tenLoai;
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "SanPham{" + "idSanPham=" + idSanPham + ", ten=" + ten + ", moTa=" + moTa + ", donViTinh=" + donViTinh + ", tenLoai=" + tenLoai + ", gia=" + gia + '}';
    }
    
}