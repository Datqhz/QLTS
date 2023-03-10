/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testing;

import com.nhom13.DAO.LoaiMonDao;
import com.nhom13.DAO.VaiTroDAO;
import com.nhom13.Entity.LoaiMon;
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
public class LoaiMonDaoTest {
    
    public LoaiMonDaoTest() {
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
    public void testFindAll() throws Exception{
        LoaiMonDao dao = new LoaiMonDao();
        List<LoaiMon> listt = dao.findAll();
        listt.forEach(l -> System.out.println(l));
        assertTrue(listt.size() > 0);
        
    }
    
    @Test 
    public void saveNew(){
        LoaiMon lm = new LoaiMon();
        LoaiMonDao dao = new LoaiMonDao();
        lm.setId(1000);
        lm.setTen("test");
        lm.setMaNv("1");
        dao.save(lm);
        assertTrue(dao.findById(1000) != null);
        
    }
    @Test 
    public void update(){
        LoaiMon lm = new LoaiMon();
        LoaiMonDao dao = new LoaiMonDao();
        lm.setId(1000);
        lm.setTen("test1");
        lm.setMaNv("12");
        dao.update(lm, "1000");
        
        
    }
    @Test
    public void delete() throws Exception{
        LoaiMon lm = new LoaiMon();
        lm.setId(1000);
        
        LoaiMonDao dao = new LoaiMonDao();
        dao.deleteLoaiMon(lm);
        
    }
}
