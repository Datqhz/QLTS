package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.ChiTietBan;
import com.nhom13.Entity.ChiTietHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import java.sql.Connection;

/**
 *
 * @author thuan
 */
public class CTHoaDonDAO {

    public List<ChiTietHoaDon> findCTHD(int idHoaDon) {
        List<ChiTietHoaDon> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            String sql = "SELECT * FROM CTHOADON WHERE SO_HOA_DON=" + idHoaDon;
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setId(resultSet.getInt(1));
                chiTietHoaDon.setIdHoaDon(resultSet.getInt(2));
                chiTietHoaDon.setIdMonAn(resultSet.getInt(3));
                chiTietHoaDon.setSoLuong(resultSet.getInt(4));
                chiTietHoaDon.setGia(resultSet.getInt(5));
                result.add(chiTietHoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<ChiTietHoaDon> findCTHD2(int idHoaDon) {
        List<ChiTietHoaDon> result = new ArrayList<>();

        String sql = "SELECT CT.ID_MON, TEN_MON , SO_LUONG, GIA "
                + "FROM (SELECT ID_MON, SO_LUONG, GIA FROM CTHOADON WHERE SO_HOA_DON  = ?) CT, (SELECT ID_MON, TEN_MON FROM MONAN) MA "
                + "WHERE CT.ID_MON = MA.ID_MON";
        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setString(1, Integer.toString(idHoaDon));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setIdMonAn(resultSet.getInt(1));
                chiTietHoaDon.setTenMon(resultSet.getString(2));
                chiTietHoaDon.setSoLuong(resultSet.getInt(3));
                chiTietHoaDon.setGia(resultSet.getInt(4));
                result.add(chiTietHoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void save(ChiTietHoaDon chiTietHoaDon) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = chiTietHoaDon.getId();
            int idHoaDon = chiTietHoaDon.getIdHoaDon();
            int idMonAn = chiTietHoaDon.getIdHoaDon();
            int quantity = chiTietHoaDon.getSoLuong();
            double gia = chiTietHoaDon.getGia();
            String sql = "INSERT INTO CTHOADON (SO_HOA_DON , ID_MON , SO_LUONG , GIA) "
                    + "           VALUES(? , ? , ? , ?)";
            statement = con.prepareCall(sql);
            statement.setInt(1, idHoaDon);
            statement.setInt(2, idMonAn);
            statement.setInt(3, quantity);
            statement.setDouble(4, gia);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public void update(ChiTietHoaDon chiTietHoaDon) {
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = DatabaseHelper.openConnection();
//            int id = chiTietHoaDon.getId();
//            int idHoaDon = chiTietHoaDon.getIdHoaDon();
//            int idMonAn = chiTietHoaDon.getIdHoaDon();
//            int quantity = chiTietHoaDon.getSoLuong();
//            int gia = chiTietHoaDon.getGia();
//            String sql = "UPDATE CTBAN SET SO_HOA_DON = ? . ID_MON = ? , SO_LUONG = ? , GIA = ? WHERE ID_CT = ?";
//            statement = con.prepareCall(sql);
//            statement.setInt(5, id);
//            statement.setInt(1, idHoaDon);
//            statement.setInt(2, idMonAn);
//            statement.setInt(3, quantity);
//            statement.setInt(4, gia);
//            statement.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void delete(ChiTietHoaDon chiTietHoaDon) {
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = DatabaseHelper.openConnection();
//            String sql = "DELETE FROM CTHOADON WHERE ID_CT = " + chiTietHoaDon.getId();
//            statement = con.prepareCall(sql);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public int TongSoHoaDon() {
        Connection con = null;
        int sum = 0;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT COUNT(*) FROM CTHOADON";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                sum += resultSet.getInt(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

}
