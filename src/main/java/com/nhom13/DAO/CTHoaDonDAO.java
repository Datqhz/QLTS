package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Ban;
import com.nhom13.Entity.ChiTietBan;
import com.nhom13.Entity.ChiTietHoaDon;
import com.nhom13.Entity.KhuyenMai;
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

    public List<ChiTietHoaDon> findCTHD2(int idHoaDon) {
        List<ChiTietHoaDon> result = new ArrayList<>();
        
        String sql = "SELECT * FROM (SELECT * FROM CTHOADON WHERE SO_HOA_DON = " + idHoaDon + ") CT, SANPHAM M WHERE CT.ID_SP=M.ID_SP";
        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setSoHoaDon(resultSet.getInt(1));
                chiTietHoaDon.setIdSize(resultSet.getInt(2));
                chiTietHoaDon.setIdMon(resultSet.getInt(3));
                chiTietHoaDon.setSoluong(resultSet.getInt(4));
                chiTietHoaDon.setGia(resultSet.getFloat(5));
                chiTietHoaDon.setTenmon(resultSet.getString(7));
                result.add(chiTietHoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Ban> findCTB(int idHoaDon) {
        List<Ban> result = new ArrayList<>();

        String sql = "SELECT CT.ID_BAN, TEN_BAN FROM (SELECT * FROM CTBAN WHERE SO_HOA_DON = " + idHoaDon + ") CT JOIN BAN M ON CT.ID_BAN =M.ID_BAN";
        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            ResultSet resultSet = statement.executeQuery();
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
    
    public KhuyenMai findKM (int idKM){
        KhuyenMai result = new KhuyenMai();

        String sql = "SELECT ID_KM, PHAN_TRAM_KM FROM KHUYENMAI where ID_KM = " +idKM;
        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.setId(resultSet.getInt(1));
                result.setGiaTri(resultSet.getInt(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
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
