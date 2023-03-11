package com.nhom13.Entity;

public class Employee {

    private String maNV;
    private String firstName;
    private String lastName;
    private String sdt;
    private String gioiTinh;
    private TaiKhoan account;
    private String diachi;
    

    //Constructor

    public Employee(String maNV, String firstName, String lastName, String sdt, String gioiTinh, TaiKhoan account, String diachi) {
        this.maNV = maNV;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.account = account;
        this.diachi = diachi;
    }

    public Employee(String maNV, String firstName, String lastName, String sdt, String gioiTinh, String diachi) {
        this.maNV = maNV;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diachi = diachi;
    }
    
    public Employee() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public TaiKhoan getAccount() {
        return account;
    }

    public void setAccount(TaiKhoan account) {
        this.account = account;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
}
