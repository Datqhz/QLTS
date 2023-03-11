package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {

    public TaiKhoan findByAccount(String account ,  String password){
        TaiKhoan tk = new TaiKhoan();
         Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM TAIKHOAN T WHERE T.TEN_TAI_KHOAN = '" + account+ "' AND T.MAT_KHAU = '" +password +"'";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
            
            tk.setTenTk(resultset.getString(1));
            tk.setMk(resultset.getString(2));
            tk.setTrangThai(resultset.getBoolean(3));
            tk.setIdQuyen(resultset.getInt(4));
            
            }
            return tk;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<TaiKhoan> findAll()  {
       List<TaiKhoan> list = new ArrayList<>();
         Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM TAIKHOAN";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
            TaiKhoan tk = new TaiKhoan();
            tk.setTenTk(resultset.getString(1));
            tk.setMk(resultset.getString(2));
            tk.setTrangThai(resultset.getBoolean(3));
            tk.setIdQuyen(resultset.getInt(4));
                
                list.add(tk);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void save(TaiKhoan account) throws Exception {
        String sql = "INSERT INTO TAIKHOAN(TEN_TAI_KHOAN, MAT_KHAU, TRANG_THAI, ID_QUYEN) VALUES(?,?,?,?)";
        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement tk = con.prepareStatement(sql);) {

            tk.setString(1, account.getTenTk());
            tk.setString(2, account.getMk());
            tk.setBoolean(3, account.isTrangThai());
            tk.setInt(4, account.getIdQuyen());
            tk.executeUpdate();
        }
    }

    public void update(TaiKhoan account) {
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement statement = null;
            String sql = "UPDATE TAIKHOAN SET MAT_KHAU = ? WHERE TEN_TAI_KHOAN = ?";
            statement = con.prepareCall(sql);
            statement.setString(1, account.getMk());
            statement.setString(2, account.getTenTk());
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
