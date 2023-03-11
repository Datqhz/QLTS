package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Ban;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

/**
 *
 * @author thuan
 */
public class BanDAO {

    public BanDAO() {
    }

    public List<Ban> findAll() {
        
        List<Ban> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM BAN";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                Ban ban = new Ban();
                ban.setId(resultset.getInt(1));
                ban.setTenBan(resultset.getString(2));
                ban.setNgayTao(resultset.getDate(3));
                ban.setTrangThai(resultset.getBoolean(4));
                result.add(ban);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void save(Ban ban) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = ban.getId();
            String tenBan = ban.getTenBan();
            Date ngayTao = ban.getNgayTao();
            boolean status = ban.getTrangThai();
            String sql = "INSERT INTO BAN (TEN_BAN , NGAY_TAO , TRANG_THAI) VALUES ( ?  , ? , ?) ";
            statement = con.prepareCall(sql);
            statement.setString(1, tenBan);
            statement.setObject(2, ngayTao);
            statement.setBoolean(3, status);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ban> searchTenBanAvailable() {
        List<Ban> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM BAN WHERE TRANG_THAI = 0";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Ban ban = new Ban();
                ban.setId(resultSet.getInt(1));
                ban.setTenBan(resultSet.getString(2));
                result.add(ban);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void update(Ban ban) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = ban.getId();
            String tenBan = ban.getTenBan();
            java.util.Date ngayTao = ban.getNgayTao();
            boolean status = ban.getTrangThai();
            String sql = "UPDATE BAN SET TEN_BAN = ? , NGAY_TAO = ? , TRANG_THAI = ? WHERE ID_BAN = " + id;
            statement = con.prepareCall(sql);
            statement.setString(1, tenBan);
            statement.setObject(2, ngayTao);
            statement.setBoolean(3, status);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Ban findById(int id) {
        Connection con = null;
        Statement statement = null;
        Ban ban = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM BAN WHERE ID_BAN = " + id;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                ban = new Ban(resultset.getInt(1),
                        resultset.getString(2),
                        resultset.getDate(3),
                        resultset.getBoolean(4));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ban;
    }

    public void deleteBan(Ban ban) {
        PreparedStatement state = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = ban.getId();
            String sql = "DELETE FROM BAN WHERE ID_BAN = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Ban> searchByName(String keyword) {
        List<Ban> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM BAN b WHERE b.TEN_BAN LIKE '%" + keyword + "%' ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                Ban ban = new Ban();
                ban.setId(resultset.getInt(1));
                ban.setTenBan(resultset.getString(2));
                ban.setNgayTao(resultset.getDate(3));
                ban.setTrangThai(resultset.getBoolean(4));
                result.add(ban);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public Ban findByName(String name) {
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM BAN b WHERE b.TEN_BAN=N'"+name+"'";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                Ban ban = new Ban();
                ban.setId(resultset.getInt(1));
                ban.setTenBan(resultset.getString(2));
                ban.setNgayTao(resultset.getDate(3));
                ban.setTrangThai(resultset.getBoolean(4));
                return ban;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
//    public List<Ban> findhByIdBill(int bill) {
//        Connection con = null;
//        Statement statement = null;
//        try {
//            con = DatabaseHelper.openConnection();
//            statement = con.createStatement();
//            String sql = "SELECT * FROM BAN b, (SELECT * FROM CT_BAN WHERE SO_HOA_DON = "+bill+") CTB WHERE b.ID_BAN = CTB.ID_BAN";
//            ResultSet resultset = statement.executeQuery(sql);
//            while (resultset.next()) {
//                Ban ban = new Ban();
//                ban.setId(resultset.getInt(1));
//                ban.setTenBan(resultset.getString(2));
//                ban.setNgayTao(resultset.getDate(3));
//                ban.setTrangThai(resultset.getBoolean(4));
//                return ban;
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }

    public List<Ban> searchTableActive() {
        List<Ban> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM BAN b WHERE b.TRANG_THAI = 0";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                Ban ban = new Ban();
                ban.setId(resultset.getInt(1));
                ban.setTenBan(resultset.getString(2));
                ban.setNgayTao(resultset.getDate(3));
                ban.setTrangThai(resultset.getBoolean(4));
                result.add(ban);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
