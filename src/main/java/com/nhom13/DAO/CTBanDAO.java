/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.ChiTietBan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuan
 */
public class CTBanDAO {

    public List<ChiTietBan> findAll() {
        List<ChiTietBan> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM CTBAN ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ChiTietBan chiTietBan = new ChiTietBan();
                chiTietBan.setId(resultSet.getInt(1));
                chiTietBan.setThoiGianCapNhat(resultSet.getDate(2));
                chiTietBan.setTrangThai(resultSet.getBoolean(3));
                chiTietBan.setIdBan(resultSet.getInt(4));
                chiTietBan.setIdNhanVien(resultSet.getString(5));
                result.add(chiTietBan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(ChiTietBan chiTietBan) {
        PreparedStatement statement = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            Date ngayCapNhat = chiTietBan.getThoiGianCapNhat();
            boolean trangThai = chiTietBan.isTrangThai();
            String idNhanVien = chiTietBan.getIdNhanVien();
            int idBan = chiTietBan.getIdBan();
            String sql = "INSERT INTO CTBAN(TRANG_THAI, ID_BAN , MA_NV) VALUES(? , ? , ?) ";
            statement = con.prepareCall(sql);
            statement.setBoolean(1, trangThai);
            statement.setInt(2, idBan);
            statement.setString(3, idNhanVien);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public void update(ChiTietBan chiTietBan) {
//        PreparedStatement statement = null;
//        Connection con = null;
//        try {
//            con = DatabaseHelper.openConnection();
//            int id = chiTietBan.getId();
//            Date ngayCapNhat = chiTietBan.getThoiGianCapNhat();
//            boolean trangThai = chiTietBan.isTrangThai();
//            String idNhanVien = chiTietBan.getIdNhanVien();
//            int idBan = chiTietBan.getIdBan();
//            String sql
//                    = "UPDATE CTBAN SET NGAY_TAO = ? , TRANG_THAI = ? , ID_BAN = ? , MA_NV = ? WHERE ID_CN =  " + chiTietBan.getId();
//            statement = con.prepareCall(sql);
//            statement.setObject(1, ngayCapNhat);
//            statement.setBoolean(2, trangThai);
//            statement.setInt(3, idBan);
//            statement.setString(4, idNhanVien);
//            statement.setInt(5, id);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void delete(ChiTietBan chiTietBan) {
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = DatabaseHelper.openConnection();
//            String sql = "DELETE FROM CTBAN WHERE ID_CN =  " + chiTietBan.getId();
//            statement = con.prepareCall(sql);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
