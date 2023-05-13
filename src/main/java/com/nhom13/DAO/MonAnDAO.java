package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.CTSP;
import com.nhom13.Entity.MonAn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import static java.sql.Types.NVARCHAR;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuan
 */
public class MonAnDAO {

    public List<MonAn> findAll() {
        List<MonAn> list = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = """
                         SELECT *
                         FROM SANPHAM """; 
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                MonAn ma = new MonAn();
                ma.setId(resultset.getInt(1));
                ma.setTenMon(resultset.getString(2));
                ma.setDonVi(resultset.getString(3));
                ma.setAnh(resultset.getString(4));
                ma.setMoTa(resultset.getString(5));
                ma.setIdLoaiMon(resultset.getInt(6));
                list.add(ma);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<CTSP> findCTSP(int idSp) {
        List<CTSP> list = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM CTSP WHERE ID_SP = " + idSp;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                CTSP ct = new CTSP();
                ct.setIdSanPham(resultset.getInt(1));
                ct.setIdSize(resultset.getInt(2));
                ct.setGia(resultset.getInt(3));
                list.add(ct);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
//
//    public void updateCtsp(List<CTSP> list) throws SQLException{
//        PreparedStatement statement = null;
//        Connection con = null;
//        Savepoint savepoint = null;
//        try {
//            con = DatabaseHelper.openConnection();
//            con.setAutoCommit(false);
//            savepoint = con.setSavepoint("savepoint1");
//            String sql = "UPDATE CTSP SET GIA = ? WHERE ID_SP=? AND ID_SIZE=?";
//            statement = con.prepareCall(sql);
//            for(CTSP ct : list){
//                statement.setInt(1, ct.getIdSanPham());
//                statement.setInt(2, ct.getIdSize());
//                statement.setDouble(3, ct.getGia());
//                statement.executeUpdate();
//            }
//            con.commit();
//        } catch (Exception e) {
//            con.rollback(savepoint);
//        }
//    }

//    public void saveCTSP(List<CTSP> list) throws SQLException{
//        PreparedStatement statement = null;
//        Connection con = null;
//        Savepoint savepoint = null;
//        
//        try {
//            con = DatabaseHelper.openConnection();con.setAutoCommit(false);
//            savepoint = con.setSavepoint("savepoint1");
//            String sql = "INSERT INTO CTSP(ID_SP , ID_SIZE , GIA ) VALUES(? , ? , ?)";
//            statement = con.prepareCall(sql);
//            for(CTSP ct : list){
//                statement.setInt(1, ct.getIdSanPham());
//                statement.setInt(2, ct.getIdSize());
//                statement.setDouble(3, ct.getGia());
//                statement.executeUpdate();
//            }
//            con.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            con.rollback(savepoint);
//        }
//    }

    public void updateSanPham(MonAn monAn,List<CTSP> list) throws SQLException{
        PreparedStatement statement = null;
        Connection con = null;
        Savepoint savepoint = null;
        try {
            con = DatabaseHelper.openConnection();
            
            int id = monAn.getId();
            String ten = monAn.getTenMon();
            String donVi = monAn.getDonVi();
            String anh = monAn.getAnh();
            String moTa = monAn.getMoTa();
            int idLoaiMon = monAn.getIdLoaiMon(); 
            String sql = "UPDATE SANPHAM SET TEN = ?, DON_VI_TINH =?,ANH =?, MO_TA =?, ID_LOAI_SP =? WHERE ID_SP=?";
            statement = con.prepareStatement(sql);
            con.setAutoCommit(false);
            savepoint = con.setSavepoint("savepoint1");
            statement.setString(1, ten);
            statement.setString(2, donVi);
            statement.setString(3, anh);
            statement.setString(4, moTa);
            statement.setInt(5, idLoaiMon);
            statement.setInt(6, id);
                                   System.out.println("idLoaiMon: " + idLoaiMon);
                                   System.out.println("idMon: " + id);
            statement.executeUpdate();
            String sql1 = "UPDATE CTSP SET GIA = ? WHERE ID_SP=? AND ID_SIZE=?";
            statement = con.prepareStatement(sql1);
            for(CTSP ct : list){
                statement.setInt(2, ct.getIdSanPham());
                statement.setInt(3, ct.getIdSize());
                statement.setDouble(1, ct.getGia());
                statement.executeUpdate();
               System.out.println("Complete add size" +  ct.getGia());
            }
            con.commit();
        } catch (Exception e) {
            con.rollback(savepoint);
        }

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
                monAn.setAnh(resultset.getString(4));
                monAn.setMoTa(resultset.getString(5));
                monAn.setIdLoaiMon(resultset.getInt(6));
                result.add(monAn);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void save(MonAn monAn ,List<CTSP> list) throws SQLException { 
        PreparedStatement statement = null;
        Connection con = null;
        Savepoint savepoint = null;
        try {
            con = DatabaseHelper.openConnection();
            String ten = monAn.getTenMon();
            String donVi = monAn.getDonVi();
            String anh = monAn.getAnh();
            String moTa = monAn.getMoTa();
            String sql = "INSERT INTO SANPHAM( TEN , DON_VI_TINH , ANH,  MO_TA , ID_LOAI_SP )"
                    + "           VALUES( ? , ? , ? , ?,? ) ";
            statement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            con.setAutoCommit(false);
            savepoint = con.setSavepoint("savepoint1");
            statement.setString(1, ten);
            if (monAn.getDonVi().isBlank()) {
                statement.setString(2, "Ly");
            } else {
                statement.setString(2, donVi);
            }
            statement.setString(3, anh);
            statement.setString(4, moTa);
            statement.setInt(5, monAn.getIdLoaiMon());
            statement.executeUpdate();
            int key = 0;
            try (ResultSet result = statement.getGeneratedKeys();) {
                if (result.next()) {
                    key = result.getInt(1);
                }
            }
            sql = "INSERT INTO CTSP(ID_SP , ID_SIZE , GIA ) VALUES(? , ? , ?)";
            statement = con.prepareCall(sql);
            for(CTSP ct : list){
                statement.setInt(1, key);
                statement.setInt(2, ct.getIdSize());
                statement.setDouble(3, ct.getGia());
                statement.executeUpdate();
            }
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback(savepoint);
        }

    }

    public int getId() {
        int idMon = -1;
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT MAX(ID_SP) FROM SANPHAM";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                idMon = resultset.getInt(1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return idMon;
    }

    public MonAn findById(int id) {
        Connection con = null;
        Statement statement = null;
        MonAn monAn = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM SANPHAM WHERE ID_SP = " + id;
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                monAn = new MonAn();
                monAn.setId(resultset.getInt(1));
                monAn.setTenMon(resultset.getString(2));
                monAn.setDonVi(resultset.getString(3));
                monAn.setAnh(resultset.getString(4));
                monAn.setMoTa(resultset.getString(5));
                monAn.setIdLoaiMon(resultset.getInt(6));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return monAn;
    }

    public void deleteCTSP(int idSp) {
        PreparedStatement state = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            String sql = "DELETE FROM CTSP WHERE ID_SP = " + idSp;
            state = con.prepareCall(sql);
            state.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteMonAn(MonAn monAn) {
        PreparedStatement state = null;
        Connection con = null;
        try {
            con = DatabaseHelper.openConnection();
            int id = monAn.getId();
            String sql = "DELETE FROM SANPHAM WHERE ID_SP = " + id;
            state = con.prepareCall(sql);
            state.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<MonAn> searchMonAnByName(String keyword) {
        List<MonAn> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM SANPHAM M WHERE M.TEN_SP LIKE N'%" + keyword + "%' ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                MonAn monAn = new MonAn();
                monAn.setId(resultset.getInt(1));
                monAn.setTenMon(resultset.getString(2));
                monAn.setDonVi(resultset.getString(3));
                monAn.setAnh(resultset.getString(4));
                monAn.setMoTa(resultset.getString(5));
                monAn.setIdLoaiMon(resultset.getInt(6));
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
            String sql = "SELECT * FROM SANPHAM M WHERE M.TEN = N'" + keyword + "' ";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                MonAn monAn = new MonAn();
                monAn.setId(resultset.getInt(1));
                monAn.setTenMon(resultset.getString(2));
                monAn.setDonVi(resultset.getString(3));
                monAn.setAnh(resultset.getString(4));
                monAn.setMoTa(resultset.getString(5));
                monAn.setIdLoaiMon(resultset.getInt(6));
                return monAn;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
