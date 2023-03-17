package com.nhom13.DAO;

import com.nhom13.Database.DatabaseHelper;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {

    public Employee findEmployeeByAccount(String account) throws Exception {
        String sql = "SELECT * FROM NHANVIEN WHERE TEN_TAI_KHOAN = ? ";

        try (Connection con = DatabaseHelper.openConnection(); PreparedStatement emp = con.prepareStatement(sql);) {

            emp.setString(1, account);
            ResultSet result = emp.executeQuery();

            while (result.next()) {
                Employee temp = new Employee();
                temp.setMaNV(result.getString(1));
                temp.setFirstName(result.getString(2));
                temp.setLastName(result.getString(3));
                temp.setSdt(result.getString(4));
                temp.setDiachi(result.getString(5));
                temp.setGioiTinh(result.getString(6));
                return temp;
            }
            return null;
        }
    }

    public void saveEmployee(Employee employee) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            String maNV = employee.getMaNV();
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String sdt = employee.getSdt();
            String sql = "INSERT INTO NHANVIEN(MA_NV , HO , TEN, SDT, DIA_CHI,TEN_TAI_KHOAN ,GIOI_TINH)"
                    + "VALUES(? , ? , ? ,?,?,?,?)";
            statement = con.prepareCall(sql);
            statement.setString(1, maNV);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, sdt);
            statement.setString(5, employee.getDiachi());
            statement.setString(6, employee.getAccount().getTenTk());
            statement.setString(7, employee.getGioiTinh());
            statement.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement statement = null;
            String maNV = employee.getMaNV();
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String sdt = employee.getSdt();
            String sql = "UPDATE NHANVIEN SET  HO = ? , TEN = ?,"
                    + "SDT = ? ,DIA_CHI=?, GIOI_TINH = ?  WHERE MA_NV = ? ";
            String sql2 = "UPDATE TAIKHOAN SET TRANG_THAI =?, ID_QUYEN = ? WHERE TEN_TAI_KHOAN =?";
            statement = con.prepareCall(sql);
            statement.setString(6, maNV);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, sdt);
            statement.setString(4, employee.getDiachi());
            statement.setString(5, employee.getGioiTinh());
            statement.executeUpdate();
            statement = con.prepareCall(sql2);
            statement.setBoolean(1, employee.getAccount().isTrangThai());
            statement.setInt(2, employee.getAccount().getIdQuyen());
            statement.setString(3, employee.getAccount().getTenTk());
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Employee> findAll() throws Exception {
        List<Employee> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {

            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT N.MA_NV , N.HO , N.TEN, N.SDT ,N.DIA_CHI,N.GIOI_TINH,N.TEN_TAI_KHOAN , T.MAT_KHAU,T.TRANG_THAI,T.ID_QUYEN\n"
                    + "FROM NHANVIEN N JOIN TAIKHOAN T ON N.TEN_TAI_KHOAN = T.TEN_TAI_KHOAN";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                Employee employee = new Employee();
                employee.setMaNV(resultset.getString(1));
                employee.setFirstName(resultset.getString(2));
                employee.setLastName(resultset.getString(3));
                employee.setSdt(resultset.getString(4));
                employee.setDiachi(resultset.getString(5));
                employee.setGioiTinh(resultset.getString(6));
                TaiKhoan acc = new TaiKhoan();
                acc.setTenTk(resultset.getString(7));
                acc.setMk(resultset.getString(8));
                acc.setTrangThai(resultset.getBoolean(9));
                acc.setIdQuyen(resultset.getInt(10));
                employee.setAccount(acc);
                result.add(employee);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public List<Employee> searchNhanVienByName(String keyword) throws Exception {
        List<Employee> result = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        try {
            con = DatabaseHelper.openConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM  NHANVIEN NV, TAIKHOAN TK WHERE NV.TEN_TAI_KHOAN = TK.TEN_TAI_KHOAN AND CONCAT(NV.HO,' ',NV.TEN) LIKE N'%" + keyword + "%'";
            ResultSet resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                Employee employee = new Employee();
                employee.setMaNV(resultset.getString(1));
                employee.setFirstName(resultset.getString(2));
                employee.setLastName(resultset.getString(3));
                employee.setSdt(resultset.getString(4));
                employee.setDiachi(resultset.getString(5));
                employee.setGioiTinh(resultset.getString(6));
                TaiKhoan acc = new TaiKhoan();
                acc.setTenTk(resultset.getString(7));
                acc.setMk(resultset.getString(9));
                acc.setTrangThai(resultset.getBoolean(10));
                acc.setIdQuyen(resultset.getInt(11));
                employee.setAccount(acc);
                result.add(employee);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
