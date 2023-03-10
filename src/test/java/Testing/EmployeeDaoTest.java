/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testing;

import com.nhom13.DAO.EmployeeDAO;
import com.nhom13.DAO.KhachHangDAO;
import com.nhom13.Entity.Employee;
import com.nhom13.Entity.KhachHang;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EmployeeDaoTest {
    
    public EmployeeDaoTest() {
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
    public void FindAll(){
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> list = null;
        try {
             list = dao.findAll();
            list.forEach(l -> System.out.println(l));
        } catch (Exception ex) {
            
        }
        assertTrue(list.size() > 0 );
        
    }
}
