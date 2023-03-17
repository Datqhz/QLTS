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

    public void save(KhuyenMai sale) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            // list ra atribute 
            // query 
            String sql = "INSERT INTO KHUYENMAI(NGAY_AP_DUNG, NGAY_KET_THUC , PHAN_TRAM_KM , LI_DO_KM ) VALUES (? , ? , ? ,?)";
            // statement.prepareCall...
            statement = con.prepareCall(sql);
            // set atributes for statement
            statement.setString(1, DateToString(sale.getNgayApDung()));
            statement.setString(2, DateToString(sale.getNgayKetThuc()));
            statement.setInt(3, sale.getGiaTri());
            statement.setString(4, sale.getLyDo());
            // statement.executeQuery
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSale(KhuyenMai sale) {
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement statement = null;
            String sql = "UPDATE KHUYENMAI SET  NGAY_AP_DUNG=? , NGAY_KET_THUC = ? , PHAN_TRAM_KM = ? , LI_DO_KM = ? WHERE ID_KM = ?";
            statement = con.prepareCall(sql);
            statement.setInt(5, sale.getId());
            statement.setString(1, DateToString(sale.getNgayApDung()));
            statement.setString(2, DateToString(sale.getNgayKetThuc()));
            statement.setInt(3, sale.getGiaTri());
            statement.setString(4, sale.getLyDo());
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

    public KhuyenMai searchByDate() {
        KhuyenMai km = null;
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHUYENMAI K\n"
                    + "where K.NGAY_AP_DUNG <= GETDATE() AND K.NGAY_KET_THUC >= GETDATE()\n"
                    + "  ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                km = new KhuyenMai();
                km.setId(resultset.getInt(1));
                km.setNgayApDung(resultset.getDate(2));
                km.setNgayKetThuc(resultset.getDate(3));
                km.setGiaTri(resultset.getInt(4));
                km.setLyDo(resultset.getString(5));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return km;
    }

    public List<KhuyenMai> searchByDate(String date) {
        List<KhuyenMai> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHUYENMAI K\n"
                    + "where K.NGAY_AP_DUNG <= '" + date + "' AND K.NGAY_KET_THUC >= '" + date + "'\n"
                    + "  ";

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

    public boolean checkKm(String fromDate, String toDate) {
        List<KhuyenMai> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM KHUYENMAI \n"
                    + "where (NGAY_AP_DUNG <= '" + fromDate + "' AND NGAY_KET_THUC >= '" + fromDate + "' ) \n"
                    + "OR  (NGAY_AP_DUNG <= '" + toDate + "' AND NGAY_KET_THUC >= '" + toDate + "' ) \n"
                    + "  ";

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
        return result.isEmpty();
    }

}
