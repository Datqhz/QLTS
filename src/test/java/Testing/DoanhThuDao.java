/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testing;

import com.nhom13.DAO.DoanhThuDAO;
import com.nhom13.Entity.DoanhThuTheoMonAn;
import com.nhom13.Entity.DoanhThuTheoNhanVien;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thuan
 */
public class DoanhThuDao {
    
    public DoanhThuDao() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testDoanhThuTheoNhanVien(){
        DoanhThuDAO dao = new DoanhThuDAO();
        String fromDate = "2023-01-01";
        String toDate = "2023-12-30";
        List<DoanhThuTheoNhanVien> lists = dao.TongDoanhThuTheoNhanVienTuNgayDenNgay(fromDate, toDate);
        lists.forEach(l -> System.out.println(l));
        assertTrue(lists.size() > 0);
    }
    @Test 
    public void get5(){
        String date = "11-2023";
        DoanhThuDAO dao = new DoanhThuDAO();        
        List<DoanhThuTheoMonAn> list = dao.topDoanhThu5MonAnTheoThoiGian(date);
        list.forEach(l -> System.out.println(l.getTenMon() + " CO " + l.getTongTien() ));
                
    }
}
