/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Testing;

import com.nhom13.DAO.DoanhThuDAO;
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
public class DoanhThuDaoTest {
    
    public DoanhThuDaoTest() {
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

    public void getDoanhThuTheoMonAn(){
        DoanhThuDAO dt = new DoanhThuDAO();
        int idMon = 1 ;
        int sum = dt.TongDoanhThuTheoMonAn(idMon);
        assertTrue(sum > 0 );
    }
}
