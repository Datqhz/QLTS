package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Ban;
import com.nhom13.Entity.ChiTietHoaDon;
import com.nhom13.Entity.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import static java.sql.Types.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuan
 */
public class HoaDonDao {

    public List<HoaDon> findAll() {
        List<HoaDon> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM HOADON";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                HoaDon hoaDon = new HoaDon();
                hoaDon.setSoHoaDon(resultSet.getInt(1));
                hoaDon.setHinhThucThanhToan(resultSet.getString(2));
                hoaDon.setNgayLap(resultSet.getString(3));
                hoaDon.setThanhTien(resultSet.getFloat(4));
                hoaDon.setIdKm(resultSet.getInt(5));
                hoaDon.setMaNv(resultSet.getString(6));
                hoaDon.setIdKh(resultSet.getInt(7));
                result.add(hoaDon);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void saveHoaDon(HoaDon hoaDon, List<Ban> listban, List<ChiTietHoaDon> listcthd) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        Savepoint savepoint = null;
        try {
            con = DatabaseHelper.openConnection();
            String sql = "INSERT INTO HOADON(HINH_THUC_TT ,THANH_TIEN , ID_KM , MA_NV ,ID_KH) "
                    + "VALUES(? , ? , ? , ? , ?  )";
            statement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            con.setAutoCommit(false);
            savepoint = con.setSavepoint("savepoint1");
            statement.setString(1, hoaDon.getHinhThucThanhToan());
            statement.setDouble(2, hoaDon.getThanhTien());
            if (hoaDon.getIdKm() == 0) {
                statement.setNull(3, INTEGER);
            } else {
                statement.setInt(3, hoaDon.getIdKm());
            }

            statement.setString(4, hoaDon.getMaNv());
            if (hoaDon.getIdKh() == 0) {
                statement.setNull(5, INTEGER);
            } else {
                statement.setInt(5, hoaDon.getIdKh());
            }
            statement.executeUpdate();
            //Lấy id vừa được tạo ra
            int key = 0;
            try (ResultSet result = statement.getGeneratedKeys();) {
                if (result.next()) {
                    key = result.getInt(1);
                }
            }
            
            //cap nhat trang thai ban va them chi tiet ban
            if (!listban.isEmpty()) {
                String sql1 = "INSERT INTO CTBAN (ID_BAN , SO_HOA_DON) VALUES ( ?,?) ";
                String sql3 = "UPDATE BAN SET TRANG_THAI = ? WHERE ID_BAN = ?" ;
                statement = con.prepareCall(sql1);
                PreparedStatement statement2 = con.prepareCall(sql3);
                statement.setInt(2, key);
                for (Ban ban : listban) {
                    statement.setInt(1, ban.getId());
                    statement.executeUpdate();
                    statement2.setBoolean(1, true);
                    statement2.setInt(2, ban.getId());
                    statement2.executeUpdate();
                }
            }
            //them chi tiet hoa don
            String sql2 = "INSERT INTO CTHOADON(SO_HOA_DON,ID_SIZE ,ID_SP , SO_LUONG , GIA) VALUES(? , ? , ? , ? , ?)";
            statement = con.prepareCall(sql2);
            statement.setInt(1, key);

            for (ChiTietHoaDon ct : listcthd) {
                statement.setInt(2, ct.getIdSize());
                statement.setInt(3, ct.getIdMon());
                statement.setInt(4, ct.getSoluong());
                statement.setDouble(5, ct.getGia());
                statement.executeUpdate();
            }
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback(savepoint);
        }
    }

    public int getIdHoaDon() {
        int id = -1;
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT MAX(SO_HOA_DON) FROM HOADON";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void saveCTBAN(int idBan, int idHoaDon) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            String sql = "INSERT INTO CTBAN (ID_BAN , SO_HOA_DON) VALUES ( ?,?) ";
            statement = con.prepareCall(sql);
            statement.setInt(1, idBan);
            statement.setInt(2, idHoaDon);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCTHOADON(int idHoaDon, int idMon, int soLuong, double gia, int idSize) {

        PreparedStatement statement = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();

            String sql = "INSERT INTO CTHOADON(SO_HOA_DON,ID_SIZE ,ID_SP , SO_LUONG , GIA) VALUES(? , ? , ? , ? , ?)";
            statement = con.prepareCall(sql);
            statement.setInt(1, idHoaDon);
            statement.setInt(2, idSize);
            statement.setInt(3, idMon);
            statement.setInt(4, soLuong);
            statement.setDouble(5, gia);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<HoaDon> findById(int id) {
        Connection con = null;
        Statement statement = null;
        List<HoaDon> billList = new ArrayList<>();
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM HOADON WHERE SO_HOA_DON=" + id;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                HoaDon hoaDon = new HoaDon();
                hoaDon.setSoHoaDon(resultSet.getInt(1));
                hoaDon.setHinhThucThanhToan(resultSet.getString(2));
                hoaDon.setNgayLap(resultSet.getString(3));
                hoaDon.setThanhTien(resultSet.getFloat(4));
                hoaDon.setIdKm(resultSet.getInt(5));
                hoaDon.setMaNv(resultSet.getString(6));
                hoaDon.setIdKh(resultSet.getInt(7));
                billList.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billList;
    }

}
