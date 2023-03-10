package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Ban;
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

public class KhuyenMaiDAO {

    public KhuyenMaiDAO() {
    }

    public static String DateToString(Date date) {

        DateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        return date_format.format(date);
    }

    public List<KhuyenMai> findAll() {
        List<KhuyenMai> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHUYENMAI ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setId(resultset.getInt(1));
                khuyenMai.setNgayApDung(resultset.getDate(2));
                khuyenMai.setNgayKetThuc(resultset.getDate(3));
                khuyenMai.setGiaTri(resultset.getInt(4));
                khuyenMai.setLyDo(resultset.getString(5));
                result.add(khuyenMai);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void save(KhuyenMai sale, String manv) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            // list ra atribute 
            // query 
            String sql = "INSERT INTO KHUYENMAI(NGAY_AP_DUNG, NGAY_KET_THUC , PHAN_TRAM_KM , LY_DO_KM , MA_NV) VALUES (? , ? , ? ,?,?)";
            // statement.prepareCall...
            statement = con.prepareCall(sql);
            // set atributes for statement
            statement.setString(1, DateToString(sale.getNgayApDung()));
            statement.setString(2, DateToString(sale.getNgayKetThuc()));
            statement.setInt(3, sale.getGiaTri());
            statement.setString(4, sale.getLyDo());
            statement.setString(5, manv);
            // statement.executeQuery
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSale(KhuyenMai sale, String manv) {
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement statement = null;
            String sql = "UPDATE KHUYENMAI SET  NGAY_AP_DUNG=? , NGAY_KET_THUC = ? , PHAN_TRAM_KM = ? , LY_DO_KM = ? , MA_NV =? WHERE ID_KM = ?";
            statement = con.prepareCall(sql);
            statement.setInt(6, sale.getId());
            statement.setString(1, DateToString(sale.getNgayApDung()));
            statement.setString(2, DateToString(sale.getNgayKetThuc()));
            statement.setInt(3, sale.getGiaTri());
            statement.setString(4, sale.getLyDo());
            statement.setString(5, manv);
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public KhuyenMai findById(int id) {
        Connection con = null;
        Statement statement = null;
        KhuyenMai khuyenMai = new KhuyenMai();
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHUYENMAI WHERE ID_KM = " + id;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                khuyenMai = new KhuyenMai();
                khuyenMai.setId(resultset.getInt(1));
                khuyenMai.setNgayApDung(resultset.getDate(2));
                khuyenMai.setNgayKetThuc(resultset.getDate(3));
                khuyenMai.setGiaTri(resultset.getInt(4));
                khuyenMai.setLyDo(resultset.getString(5));
                khuyenMai.setMaNv(resultset.getString(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return khuyenMai;
    }

    public void deleteKhuyenMai(KhuyenMai khuyenMai) {
        PreparedStatement state = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = khuyenMai.getId();
            String sql = "DELETE FROM KHUYENMAI WHERE ID_KM = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public KhuyenMai getKMInTime() throws Exception {
        KhuyenMai km;
        String sql = "SELECT ID_KM, PHAN_TRAM_KM FROM KHUYENMAI "
                + "WHERE DATEDIFF(DAY,GETDATE(),NGAY_AP_DUNG)<0 AND DATEDIFF(DAY,GETDATE(),NGAY_KET_THUC)>0";
        try (Connection con = DatabaseHelper.openConnection(); Statement statement = con.createStatement(); ResultSet result = statement.executeQuery(sql)) {
            while (result.next()) {
                km = new KhuyenMai(result.getInt(1), result.getInt(2));
                return km;
            }
        }
        return null;
    }

    public List<KhuyenMai> searchByDate(String date) {
        List<KhuyenMai> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHUYENMAI KM WHERE KM.NGAY_AP_DUNG <=  '" + date + "'AND KM.NGAY_KET_THUC >= '" + date + "' ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setId(resultset.getInt(1));
                khuyenMai.setNgayApDung(resultset.getDate(2));
                khuyenMai.setNgayKetThuc(resultset.getDate(3));
                khuyenMai.setGiaTri(resultset.getInt(4));
                khuyenMai.setLyDo(resultset.getString(5));
                khuyenMai.setMaNv(resultset.getString(6));
                result.add(khuyenMai);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
