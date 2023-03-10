package com.nhom13.Entity;

public class TaiKhoan {

  private String tenTk ;
  private String mk ;
  private boolean trangThai ;
  private int idQuyen;

    public TaiKhoan(String tenTk, String mk, boolean trangThai, int idQuyen) {
        this.tenTk = tenTk;
        this.mk = mk;
        this.trangThai = trangThai;
        this.idQuyen = idQuyen;
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdQuyen() {
        return idQuyen;
    }

    public void setIdQuyen(int idQuyen) {
        this.idQuyen = idQuyen;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tenTk=" + tenTk + ", mk=" + mk + ", trangThai=" + trangThai + ", idQuyen=" + idQuyen + '}';
    }

    public TaiKhoan() {
    }
  
  

}