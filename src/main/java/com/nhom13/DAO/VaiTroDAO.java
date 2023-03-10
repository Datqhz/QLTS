/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.DAO;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.VaiTro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuan
 */
public class VaiTroDAO {

    public List<VaiTro> findAll() {
        List<VaiTro> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM VAITRO";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                VaiTro vaiTro = new VaiTro();
                vaiTro.setId(resultSet.getInt(1));
                vaiTro.setName(resultSet.getString(2));
                result.add(vaiTro);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void save(VaiTro vaiTro) {
        PreparedStatement statement = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = vaiTro.getId();
            String tenVaiTro = vaiTro.getName();
            String sql = "INSERT INTO VAITRO(ID_VAI_TRO , TEN_VAI_TRO) VALUES(? , ? )";
            statement = con.prepareCall(sql);
            statement.setInt(1, id);
            statement.setString(2, tenVaiTro);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(VaiTro vaiTro) {
        PreparedStatement statement = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = vaiTro.getId();
            String tenVaiTro = vaiTro.getName();
            String sql = "UPDATE VAITRO SET ID_VAI_TRO = ?, TEN_VAI_TRO = ? ";
            statement = con.prepareCall(sql);
            statement.setInt(1, id);
            statement.setString(2, tenVaiTro);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public VaiTro findById(int id) {
        Connection con = null;
        Statement statement = null;
        VaiTro vaiTro = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM VAITRO WHERE ID_VAI_TRO = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                vaiTro = new VaiTro();
                vaiTro.setId(resultSet.getInt(1));
                vaiTro.setName(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vaiTro;

    }

    public void delete(VaiTro vaiTro) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM VAITRO WHERE ID_VAI_TRO = " + vaiTro.getId();
            statement = con.prepareCall(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
