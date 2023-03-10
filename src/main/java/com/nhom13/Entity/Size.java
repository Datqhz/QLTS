package com.nhom13.Entity;

/**
 *
 * @author thuan
 */
public class Size {
    private int maSize ;
    private String tenSize;

    public Size(int maSize, String tenSize) {
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public int getMaSize() {
        return maSize;
    }

    public void setMaSize(int maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    @Override
    public String toString() {
        return "Size{" + "maSize=" + maSize + ", tenSize=" + tenSize + '}';
    }
    
}