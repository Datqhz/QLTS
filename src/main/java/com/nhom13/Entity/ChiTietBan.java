package com.nhom13.Entity;

import java.sql.Date;

/**
 *
 * @author thuan
 */
public class ChiTietBan {

    private int id;
    private Date thoiGianCapNhat;
    private boolean trangThai;
    private int idBan;
    private String idNhanVien;

    public ChiTietBan() {
    }

    public ChiTietBan(boolean trangThai, int idBan, String idNhanVien) {
        this.trangThai = trangThai;
        this.idBan = idBan;
        this.idNhanVien = idNhanVien;
    }

    public ChiTietBan(int id, Date thoiGianCapNhat, boolean trangThai, int idBan, String idNhanVien) {
        this.id = id;
        this.thoiGianCapNhat = thoiGianCapNhat;
        this.trangThai = trangThai;
        this.idBan = idBan;
        this.idNhanVien = idNhanVien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getThoiGianCapNhat() {
        return thoiGianCapNhat;
    }

    public void setThoiGianCapNhat(Date thoiGianCapNhat) {
        this.thoiGianCapNhat = thoiGianCapNhat;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    @Override
    public String toString() {
        return "ChiTietBan{" + "id=" + id + ", thoiGianCapNhat=" + thoiGianCapNhat + ", trangThai=" + trangThai + ", idBan=" + idBan + ", idNhanVien=" + idNhanVien + '}';
    }

}
