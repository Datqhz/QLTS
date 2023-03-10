/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testing;

import com.nhom13.DAO.MonAnDAO;
import com.nhom13.DAO.VaiTroDAO;
import com.nhom13.Entity.MonAn;
import com.nhom13.Entity.VaiTro;
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
public class MonAnDaoTest {
    
    public MonAnDaoTest() {
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
    public void testFindAll(){
        MonAnDAO dao = new MonAnDAO();
        List<MonAn> list = dao.findAll();
        list.forEach(monAn -> System.out.println(monAn));
        assertTrue(list.size() > 0);
    }
    
    @Test 
    public void saveNew(){
        MonAn ma = new MonAn();
        ma.setId(1000);
        ma.setTenMon("test");
        ma.setAnh("test.png");
        ma.setDonVi("ly");
        ma.setGia(11111);
        ma.setIdLoaiMon(2);
        ma.setMoTa("mota");
        ma.setIdLoaiMon(1);
        MonAnDAO dao = new MonAnDAO();
        dao.save(ma);
        assertTrue(dao.findById(1000) != null);
    }
    @Test 
    public void update(){
        MonAn ma = new MonAn();
        ma.setId(1000);
        ma.setTenMon("test1");
        ma.setAnh("test.jpg");
        ma.setDonVi("ly");
        ma.setGia(11111);
        ma.setIdLoaiMon(2);
        ma.setMoTa("mota");
        ma.setIdLoaiMon(1);
        MonAnDAO dao = new MonAnDAO();
        dao.save(ma);
        assertTrue(dao.findById(1000).getTenMon().equals("test1"));
       
        
    }
    @Test
    public void delete(){
        MonAnDAO dao = new MonAnDAO();
        MonAn ma = dao.findById(1000);
        dao.deleteMonAn(ma);
        assertTrue(ma == null);
    }
}
