package com.nhom13.Entity;

import java.util.Date;

/**
 *
 * @author thuan
 */
public class KhachHang {

    private int id;
    private String ho;
    private String ten;
    private String sdt;
    private Date ngaySinh;

    public KhachHang() {
    }

    public KhachHang(String ho, String ten, String sdt, Date ngaySinh) {
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
    }

    public KhachHang(int id, String ho, String ten, String sdt, Date ngaySinh) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", ho=" + ho + ", ten=" + ten + ", sdt=" + sdt + ", ngaySinh=" + ngaySinh + '}';
    }

}
