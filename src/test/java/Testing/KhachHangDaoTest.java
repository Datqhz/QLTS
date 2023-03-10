/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testing;

import com.nhom13.DAO.KhachHangDAO;
import com.nhom13.Entity.KhachHang;
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
public class KhachHangDaoTest {
    
    public KhachHangDaoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testSaveKhachHang(){
        KhachHang kh = new KhachHang();
        kh.setId(1000);
        kh.setHo("NGO");
        kh.setTen("Thuan");
        kh.setNgaySinh(null);
        kh.setSdt("019999922");
        KhachHangDAO dao = new KhachHangDAO();
        dao.save(kh);
        assertTrue(dao.findById(1000) != null);
    }
    @Test
    public void testUpdateKhachHang(){
        KhachHang kh = new KhachHang();
        kh.setId(1000);
        kh.setSdt("09111111");
        KhachHangDAO dao = new KhachHangDAO();
        dao.update(kh);
        assertTrue(dao.findById(1000) != null);
    }
    @Test
    public void deleteKhachHang(){
        KhachHang kh = new KhachHang();
        kh.setId(1000);
        KhachHangDAO dao = new KhachHangDAO();
        dao.deleteKhachHang(kh);
        assertTrue(dao.findById(1000) == null);
    }
    @Test
    public void findAllKhachHang(){
        KhachHangDAO dao = new KhachHangDAO();
        List<KhachHang> list = dao.findAll();
        assertTrue(list.size() > 0);
       
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
