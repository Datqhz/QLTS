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
public class Ban {

    private int id;
    private String tenBan;
    private Date ngayTao;
    private Boolean trangThai;

    public Ban() {
    }

    public Ban(String tenBan, Date ngayTao) {
        this.tenBan = tenBan;
        this.ngayTao = ngayTao;
    }

    public Ban(int id, String tenBan, Date ngayTao, Boolean trangThai) {
        this.id = id;
        this.tenBan = tenBan;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Ban{" + "id=" + id + ", tenBan=" + tenBan + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + '}';
    }

}
