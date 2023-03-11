package com.nhom13.Entity;

import java.util.ArrayList;
import java.util.List;

public class MonAn {

    private int id;
    private String tenMon;
    private String donVi;
    private String anh;
    private String moTa;
    private int idLoaiMon;
    public MonAn() {
    }

    public MonAn(int id, String tenMon, String donVi, String anh, String moTa,  int idLoaiMon) {
        this.id = id;
        this.tenMon = tenMon;
        this.donVi = donVi;
        this.anh = anh;
        this.moTa = moTa;
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


    public int getIdLoaiMon() {
        return idLoaiMon;
    }

    public void setIdLoaiMon(int idLoaiMon) {
        this.idLoaiMon = idLoaiMon;
    }

    @Override
    public String toString() {
        return "MonAn{" + "id=" + id + ", tenMon=" + tenMon + ", donVi=" + donVi + ", anh=" + anh + ", moTa=" + moTa + ", idLoaiMon=" + idLoaiMon + '}';
    }
    

}
