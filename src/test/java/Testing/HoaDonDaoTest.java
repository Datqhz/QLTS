///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package Testing;
//
//import com.nhom13.DAO.HoaDonDao;
//import com.nhom13.Entity.HoaDon;
//import java.util.List;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author thuan
// */
//public class HoaDonDaoTest {
//    
//    public HoaDonDaoTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    // @Test
//    // public void hello() {}
//    
//    
//    @Test
//    public void findAll(){
//        HoaDonDao dao = new HoaDonDao();
//        List<HoaDon> list = dao.findAll();
//        list.forEach(HoaDon -> System.out.println(HoaDon));
//        assertTrue(list.size() > 0);
//    }
//    @Test 
//    public void save(){
//        HoaDon hoaDon = new HoaDon();
//        HoaDonDao dao = new HoaDonDao();
//        hoaDon.setId(1000);
//        hoaDon.setTenBan(null);
//        hoaDon.setHinhThucThanhToan("CK");
//        hoaDon.setThanhTien(1000000);
//        hoaDon.setIdNhanVien("1");
//        hoaDon.setNgayLap(null);
//        
//        dao.save(hoaDon);
//        // find by id 
//        HoaDon savedHoaDon = (HoaDon) dao.findById(1000);
//        assertTrue(savedHoaDon != null);
//              
//    }
//    @Test
//    public void update(){
//       
//       HoaDonDao dao = new HoaDonDao();
//       HoaDon hd = dao.findById(1);
//       hd.setTenBan("A2");
//       dao.upate(hd);
//       assertTrue("A2".equals(dao.findById(1).getTenBan()));
//       
//        
//        
//       
//    }
//    
//    @Test
//    public void delete(){
//        HoaDonDao dao = new HoaDonDao();
//        HoaDon hoaDon = dao.findById(1);
//        dao.delete(hoaDon);
//        assertTrue(dao.findById(1) == null);
//               
//    }
//    
//}
