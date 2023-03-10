package com.nhom13.Entity;

public class MonAn {

    private int id;
    private String tenMon;
    private String donVi;
    private int gia;
    private String anh;
    private String moTa;
    private String maNv;
    private int idLoaiMon;

    public MonAn() {
    }

    public MonAn(int id, String tenMon, String donVi, int gia, String anh, String moTa, String maNv, int idLoaiMon) {
        this.id = id;
        this.tenMon = tenMon;
        this.donVi = donVi;
        this.gia = gia;
        this.anh = anh;
        this.moTa = moTa;
        this.maNv = maNv;
        this.idLoaiMon = idLoaiMon;
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

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public int getIdLoaiMon() {
        return idLoaiMon;
    }

    public void setIdLoaiMon(int idLoaiMon) {
        this.idLoaiMon = idLoaiMon;
    }

    @Override
    public String toString() {
        return "MonAn{" + "id=" + id + ", tenMon=" + tenMon + ", donVi=" + donVi + ", gia=" + gia + ", anh=" + anh + ", moTa=" + moTa + ", maNv=" + maNv + ", idLoaiMon=" + idLoaiMon + '}';
    }

}
