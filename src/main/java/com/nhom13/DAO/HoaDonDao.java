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
                hoaDon.setThanhTien(resultSet.getInt(4));
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
    public void save(HoaDon hoaDon) {
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            // list ra atribute 
            String type = hoaDon.getHinhThucThanhToan();
//            Date ngayLap = hoaDon.getNgayLap();
            double sum = hoaDon.getThanhTien();
            int idBan = hoaDon.getIdBan();
            String maNv = hoaDon.getIdNhanVien();
            int idKhuyenMai = hoaDon.getIdKhuyenMai();
            int idKhachHang = hoaDon.getIdKhachHang();

            // query 
            String sql = "INSERT INTO HOADON(HINH_THUC_TT ,  THANH_TIEN , "
                    + "ID_BAN , MA_NV , ID_KM, ID_KH) VALUES (? , ? , ?,? ,?,?)";
            // statement.prepareCall...
            PreparedStatement statement = con.prepareStatement(sql);
            // set atributes for statement
            statement.setString(1, type);
//            statement.setObject(2, ngayLap);
            statement.setDouble(2, sum);
            if (hoaDon.getIdBan() == 0) {
                statement.setNull(3, INTEGER);
            } else {
                statement.setInt(3, idBan);
            }
            statement.setString(4, maNv);

            if (hoaDon.getIdKhuyenMai() == 0) {
                statement.setNull(5, INTEGER);
            } else {
                statement.setInt(5, idKhuyenMai);
            }
            if (hoaDon.getIdKhachHang() == 0) {
                statement.setNull(6, INTEGER);
            } else {
                statement.setInt(6, idKhachHang);
            }
            statement.executeUpdate();

            // Lấy số hóa đơn vừa tạo
            String sql1 = "SELECT IDENT_CURRENT('HOADON') as LastID";
            Statement getIdOrder = con.createStatement();
            ResultSet resultSet = getIdOrder.executeQuery(sql1);
            int idhd = 0;
            while (resultSet.next()) {
                idhd = resultSet.getInt(1);
            }
            // Thêm chi tiết hóa đơn
            List<ChiTietHoaDon> list = hoaDon.getFoodList();
            for (ChiTietHoaDon ct : list) {
                int idMonAn = ct.getIdMonAn();
                int quantity = ct.getSoLuong();
                double gia = ct.getGia();
                String sql2 = "INSERT INTO CTHOADON (SO_HOA_DON , ID_MON , SO_LUONG , GIA) "
                        + "           VALUES(? , ? , ? , ?)";
                statement = con.prepareStatement(sql2);
                statement.setInt(1, idhd);
                statement.setInt(2, idMonAn);
                statement.setInt(3, quantity);
                statement.setDouble(4, gia);
                statement.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<HoaDon> findById(int id) {
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM HOADON WHERE SO_HOA_DON=" + id;
            ResultSet resultSet = statement.executeQuery(sql);
            HoaDon bill = new HoaDon();
            while (resultSet.next()) {

                bill.setId(resultSet.getInt(1));
                bill.setHinhThucThanhToan(resultSet.getString(2));
                bill.setNgayLap(resultSet.getDate(3));
                bill.setThanhTien(resultSet.getInt(4));
                bill.setIdBan(resultSet.getInt(5));
                bill.setIdNhanVien(resultSet.getString(6));
                bill.setIdKhuyenMai(resultSet.getInt(7));
                bill.setIdKhachHang(resultSet.getInt(8));
            }
            CTHoaDonDAO ctdao = new CTHoaDonDAO();
            List<ChiTietHoaDon> ct = ctdao.findCTHD(id);
            bill.setFoodList(ct);
            List<HoaDon> billList = new ArrayList<>();
            billList.add(bill);
            return billList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public void upate(HoaDon hoaDon) {
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = DatabaseHelper.openConnection();
//            // list ra atribute 
//            int id = hoaDon.getId();
//            String type = hoaDon.getHinhThucThanhToan();
//            Date ngayLap = hoaDon.getNgayLap();
//            int sum = hoaDon.getThanhTien();
//            int idBan = hoaDon.getIdBan();
//            String maNv = hoaDon.getIdNhanVien();
//            int idKhuyenMai = hoaDon.getIdKhuyenMai();
//            int idKhachHang = hoaDon.getIdKhachHang();
//
//            // query 
//            String sql = "UPDATE HOADON SET HINH_THUC_TT = ? , NGAY_LAP = ?, THANH_TIEN , ID_BAN = ?, MA_NV = ? , ID_KHUYEN_MAI = ? ,"
//                    + "ID_KHACH_HANG = ?  WHERE SO_HOA_DON = " + id;
//            // statement.prepareCall...
//            statement = con.prepareCall(sql);
//            // set atributes for statement
//            statement.setInt(8, id);
//            statement.setString(1, type);
//            statement.setObject(2, ngayLap);
//            statement.setInt(3, sum);
//            statement.setInt(4, idBan);
//            statement.setString(5, maNv);
//            statement.setInt(6, idKhuyenMai);
//            statement.setInt(7, idKhachHang);
//            // statement.executeQuery
//            statement.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void delete(HoaDon hoaDon) {
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = DatabaseHelper.openConnection();
//            String sql = "DELETE FROM HOADON WHERE SO_HOA_DON = " + hoaDon.getId();
//            statement = con.prepareCall(sql);
//            statement.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
