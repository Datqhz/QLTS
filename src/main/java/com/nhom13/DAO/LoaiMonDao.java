/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.LoaiMon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuan
 */
public class LoaiMonDao {

    public List<LoaiMon> findAll() throws Exception {
        List<LoaiMon> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM LOAISP";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                LoaiMon loaimon = new LoaiMon(resultset.getInt(1), resultset.getString(2));
                result.add(loaimon);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;

    }

//    public LoaiMon findById(int id) {
//        Connection con = null;
//        Statement statement = null;
//        LoaiMon loaiMon = new LoaiMon();
//        try {
//            con = DatabaseHelper.openConnection();
//            statement = con.createStatement();
//            String sql = "SELECT * LOAIMON WHERE ID_LOAI_MON = " + id;
//            ResultSet resultset = statement.executeQuery(sql);
//            while (resultset.next()) {
//                loaiMon = new LoaiMon(resultset.getInt(1), resultset.getString(2), resultset.getString(3));
//
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return loaiMon;
//    }

    public void update(LoaiMon loaiMon) {
        PreparedStatement state = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = loaiMon.getId();
            String name = loaiMon.getTen();
            String sql = "UPDATE  LOAISP SET TEN_LOAI_SP = ? WHERE ID_LOAI_SP =  " + id;
            state = con.prepareCall(sql);
            state.setString(1, name);
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // addd 
    public void save(LoaiMon loaiMon) {
        PreparedStatement state = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = loaiMon.getId();
            String name = loaiMon.getTen();
            String sql = "INSERT INTO LOAISP(TEN_LOAI_SP) VALUES( ? ) ";
            state = con.prepareCall(sql);
            state.setString(1, name);
            state.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteLoaiMon(LoaiMon loaiMon) throws Exception {
        PreparedStatement state = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = loaiMon.getId();
            String sql = "DELETE FROM LOAISP WHERE ID_LOAI_SP = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<LoaiMon> SearchLoaiMon(String keyword) throws Exception {
        List<LoaiMon> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM LOAISP L WHERE L.TEN_LOAI_SP LIKE '%" + keyword + "%' ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                LoaiMon loaimon = new LoaiMon(resultset.getInt(1), resultset.getString(2));
                result.add(loaimon);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
        public LoaiMon SearchTenLoaiMon(String name) throws Exception {
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM LOAISP L WHERE L.TEN_LOAI_SP = N'" +name+"'";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                LoaiMon result = new LoaiMon(resultset.getInt(1), resultset.getString(2));
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
        
    }

}
