/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testing;

import com.nhom13.DAO.BanDAO;
import com.nhom13.Entity.Ban;
import java.util.ArrayList;
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
public class BanDaoTest {
    
   
    
    
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
    
   
    @Test
    public void findAllBan(){
        BanDAO dao = new BanDAO();
        List<Ban> bans = new ArrayList<>();
       try{
          
          bans = dao.findAll();
          bans.forEach(ban -> System.out.println(ban));
       
       } catch(Exception e){
           e.printStackTrace();
       }
        assertTrue(bans.size() > 0);
    }
    
    @Test 
    public void saveBan(){
        BanDAO dao = new BanDAO();
        Ban ban = new Ban();
        ban.setTenBan("test3");
        ban.setTrangThai(true);
        dao.save(ban);
    }
    
    @Test
    public  void updateBan(){
        BanDAO dao = new BanDAO();
        Ban ban = dao.findById(1);
        System.out.println(ban);
        ban.setTenBan("test4");
        dao.update(ban);
        Ban banAfterUpdated = dao.findById(1);
        assertTrue(banAfterUpdated != ban);
    }

    @Test
    public void deleteBan(){
        BanDAO dao = new BanDAO();
        Ban ban =dao.findById(1);
        dao.deleteBan(ban);
        Ban banAfterDelete =dao.findById(1);
        assertTrue(banAfterDelete == null);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
