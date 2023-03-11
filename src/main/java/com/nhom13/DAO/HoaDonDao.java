package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.ChiTietHoaDon;
import com.nhom13.Entity.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

//    public int getNewId() {
//        Connection con = null;
//        Statement statement = null;
//        int id = 0;
//        try {
//            con = DatabaseHelper.openConnection();
//            statement = con.createStatement();
//            String sql = "SELECT IDENT_CURRENT('HOADON') as LastID";
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                id = resultSet.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return id;
//
//    }
     public void saveHoaDon(HoaDon hoaDon){
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            String sql = "INSERT INTO HOADON(HINH_THUC_TT ,THANH_TIEN , ID_KM , MA_NV ,ID_KH) "
                    + "VALUES(? , ? , ? , ? , ?  )";
            statement = con.prepareCall(sql);
            statement.setString(1, hoaDon.getHinhThucThanhToan());
            statement.setDouble(2, hoaDon.getThanhTien());
            if(hoaDon.getIdKm()==0){
                statement.setNull(3, INTEGER);
            }else{
                statement.setInt(3, hoaDon.getIdKm());
            }
            
            statement.setString(4, hoaDon.getMaNv());
            if(hoaDon.getIdKh()==0){
                statement.setNull(5, INTEGER);
            }else{
                statement.setInt(5, hoaDon.getIdKh());
            }
            
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public int getIdHoaDon(){
        int id = -1 ;
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT MAX(SO_HOA_DON) FROM HOADON";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                id  = resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

     public void saveCTBAN(int idBan , int idHoaDon){
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
     public void saveCTHOADON(int idHoaDon , int idMon , int soLuong , double gia , int idSize){
        
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
        List<HoaDon>billList = new ArrayList<>();
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
