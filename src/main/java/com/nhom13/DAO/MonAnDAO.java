package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.MonAn;
import com.nhom13.Entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.sql.Types.NVARCHAR;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuan
 */
public class MonAnDAO {

    public List<SanPham> findAll(){
        List<SanPham> list = new ArrayList<>();
         Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = """
                         SELECT S.ID_SP ,TEN , DON_VI_TINH, MO_TA ,L.TEN_LOAI_SP,SI.TEN_SIZE , C.GIA 
                         FROM SANPHAM S
                         JOIN CTSP C ON S.ID_SP = C.ID_SP
                         JOIN LOAISP L ON S.ID_LOAI_SP = L.ID_LOAI_SP
                         JOIN SIZE SI ON SI.ID_SIZE = C.ID_SIZE""";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                SanPham sp = new SanPham();
                sp.setIdSanPham(resultset.getInt(1));
                sp.setTen(resultset.getString(2));
                sp.setDonViTinh(resultset.getString(3));
                sp.setMoTa(resultset.getString(4));
                sp.setTenLoai(resultset.getString(5));
                sp.setSize(resultset.getString(6));
                sp.setGia(resultset.getInt(7));
                
                list.add(sp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public List<MonAn> findByCategory(int id) {
        List<MonAn> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM SANPHAM WHERE ID_LOAI_SP =" + id;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                MonAn monAn = new MonAn();
                monAn.setId(resultset.getInt(1));
                monAn.setTenMon(resultset.getString(2));
                monAn.setDonVi(resultset.getString(3));
                monAn.setGia(resultset.getInt(4));
                monAn.setAnh(resultset.getString(5));
                monAn.setMoTa(resultset.getString(6));
                monAn.setIdLoaiMon(resultset.getInt(7));
                result.add(monAn);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void save(MonAn monAn) {
        PreparedStatement statement = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = monAn.getId();
            String ten = monAn.getTenMon();
            String donVi = monAn.getDonVi();
            int gia = monAn.getGia();
            String anh = monAn.getAnh();
            String moTa = monAn.getMoTa();
            int idLoaiMon = monAn.getIdLoaiMon();
            String maNv = monAn.getMaNv();
            String sql = "INSERT INTO MONAN( TEN_MON , DON_VI_TINH , GIA ,ANH,  MO_TA , ID_LOAI_MON , MA_NV)"
                    + "           VALUES( ? , ? , ? , ? , ? , ?,? ) ";
            statement = con.prepareCall(sql);
            statement.setString(1, ten);
            if (monAn.getDonVi().isBlank()) {
                statement.setNull(2, NVARCHAR);
            } else {
                statement.setString(2, donVi);
            }

            statement.setString(2, donVi);
            statement.setInt(3, gia);
            statement.setString(4, anh);
            statement.setString(5, moTa);
            statement.setInt(6, idLoaiMon);
            statement.setString(7, maNv);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(MonAn monAn) {
        PreparedStatement statement = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = monAn.getId();
            String ten = monAn.getTenMon();
            String donVi = monAn.getDonVi();
            int gia = monAn.getGia();
            String anh = monAn.getAnh();
            String moTa = monAn.getMoTa();
            int idLoaiMon = monAn.getIdLoaiMon();
            String maNv = monAn.getMaNv();
            String sql = "UPDATE MONAN SET TEN_MON = ?, DON_VI_TINH =?, GIA = ?,ANH =?, MO_TA =?, ID_LOAI_MON =?, MA_NV =? WHERE ID_MON=?";
            statement = con.prepareCall(sql);
            statement.setInt(8, id);
            statement.setString(1, ten);
            statement.setString(2, donVi);
            statement.setInt(3, gia);
            statement.setString(4, anh);
            statement.setString(5, moTa);
            statement.setInt(6, idLoaiMon);
            statement.setString(7, maNv);
            statement.executeUpdate();
        } catch (Exception e) {
        }

    }

    public MonAn findById(int id) {
        Connection con = null;
        Statement statement = null;
        MonAn monAn = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM MONAN WHERE ID_MON = " + id;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                monAn = new MonAn();
                monAn.setId(resultset.getInt(1));
                monAn.setTenMon(resultset.getString(2));
                monAn.setDonVi(resultset.getString(3));
                monAn.setGia(resultset.getInt(4));
                monAn.setAnh(resultset.getString(5));
                monAn.setMoTa(resultset.getString(6));
                monAn.setMaNv(resultset.getString(7));
                monAn.setIdLoaiMon(resultset.getInt(8));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return monAn;
    }

    public void deleteMonAn(MonAn monAn) {
        PreparedStatement state = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = monAn.getId();
            String sql = "DELETE FROM MONAN WHERE ID_MON = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<MonAn> searchMonAnByName(String keyword) {
        List<MonAn> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM MONAN M WHERE M.TEN_MON LIKE '%" + keyword + "%' ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                MonAn monAn = new MonAn();
                monAn.setId(resultset.getInt(1));
                monAn.setTenMon(resultset.getString(2));
                monAn.setDonVi(resultset.getString(3));
                monAn.setGia(resultset.getInt(4));
                monAn.setAnh(resultset.getString(5));
                monAn.setMoTa(resultset.getString(6));
                monAn.setIdLoaiMon(resultset.getInt(7));
                monAn.setMaNv(resultset.getString(8));
                result.add(monAn);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
        public MonAn findMonAnByName(String keyword) {
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM MONAN M WHERE M.TEN_MON LIKE '%" + keyword + "%' ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                MonAn monAn = new MonAn();
                monAn.setId(resultset.getInt(1));
                monAn.setTenMon(resultset.getString(2));
                monAn.setDonVi(resultset.getString(3));
                monAn.setGia(resultset.getInt(4));
                monAn.setAnh(resultset.getString(5));
                monAn.setMoTa(resultset.getString(6));
                monAn.setIdLoaiMon(resultset.getInt(7));
                monAn.setMaNv(resultset.getString(8));
                return monAn;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
