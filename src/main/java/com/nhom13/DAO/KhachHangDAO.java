/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.KhachHang;
import com.nhom13.Entity.KhuyenMai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thuan
 */
public class KhachHangDAO {

    public String DateToString(Date date) {
        DateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        return date_format.format(date);
    }

    public List<KhachHang> findAll() {
        List<KhachHang> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHACHHANG ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(resultset.getInt(1));
                khachHang.setHo(resultset.getString(2));
                khachHang.setTen(resultset.getString(3));
                khachHang.setNgaySinh(resultset.getDate(4));
                khachHang.setSdt(resultset.getString(5));
                result.add(khachHang);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void save(KhachHang temp) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            String ho = temp.getHo();
            String ten = temp.getTen();
            String sdt = temp.getSdt();
            Date ns = temp.getNgaySinh();

            String sql = "INSERT INTO KHACHHANG( HO, TEN, SDT, NGAY_SINH)"
                    + "VALUES(? , ? , ? ,? )";
            statement = con.prepareCall(sql);
            statement.setString(1, ho);
            statement.setString(2, ten);
            statement.setString(3, sdt);
            statement.setString(4, DateToString(ns));
            statement.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void update(KhachHang client) {
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement statement = null;
            String sql = "UPDATE KHACHHANG SET  HO = ? , TEN = ? , SDT = ? , NGAY_SINH = ? WHERE ID_KH = ?";
            statement = con.prepareCall(sql);
            statement.setInt(5, client.getId());
            statement.setString(1, client.getHo());
            statement.setString(2, client.getTen());
            statement.setString(3, client.getSdt());
            statement.setString(4, DateToString(client.getNgaySinh()));
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public KhachHang findById(int id) {
        Connection con = null;
        Statement statement = null;
        KhachHang khachHang = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHACHHANG  WHERE ID_KH = " + id;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                khachHang = new KhachHang();
                khachHang.setId(resultset.getInt(1));
                khachHang.setHo(resultset.getString(2));
                khachHang.setTen(resultset.getString(3));
                khachHang.setSdt(resultset.getString(4));
                khachHang.setNgaySinh(resultset.getDate(5));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return khachHang;
    }

    public void deleteKhachHang(KhachHang khachHang) {
        PreparedStatement state = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = khachHang.getId();
            String sql = "DELETE FROM KHACHHANG WHERE ID_KH = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<KhachHang> searchByName(String keyword) {
        List<KhachHang> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHACHHANG K WHERE CONCAT(K.HO, ' ' ,K.TEN) LIKE '%" + keyword + "%' ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(resultset.getInt(1));
                khachHang.setHo(resultset.getString(2));
                khachHang.setTen(resultset.getString(3));
                khachHang.setNgaySinh(resultset.getDate(4));
                khachHang.setSdt(resultset.getString(5));
                result.add(khachHang);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
