
package com.nhom13.Entity;

/**
 *
 * @author thuan
 */
public class CTSP {
    private int idSanPham;
    private int idSize;
    private int gia;

    public CTSP(int idSanPham, int idSize, int gia) {
        this.idSanPham = idSanPham;
        this.idSize = idSize;
        this.gia = gia;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    @Override
    public String toString() {
        return "CTSP{" + "idSanPham=" + idSanPham + ", idSize=" + idSize + ", gia=" + gia + '}';
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public CTSP() {
    }
    
}
