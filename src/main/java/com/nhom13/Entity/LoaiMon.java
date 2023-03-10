package com.nhom13.Entity;

/**
 *
 * @author thuan
 */
public class LoaiMon {

    private int id;
    private String ten;

    public LoaiMon() {
    }

    public LoaiMon(String ten) {
        this.ten = ten;
    }

    public LoaiMon(int id, String ten){
        this.id=id;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "LoaiMon{" + "id=" + id + ", ten=" + ten + "}";
    }

}
