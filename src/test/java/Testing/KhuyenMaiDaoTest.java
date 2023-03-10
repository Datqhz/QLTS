
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
public class KhuyenMaiDaoTest {
    
    public KhuyenMaiDaoTest() {
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
        KhachHangDAO dao = new KhachHangDAO();
        List<KhachHang> list = dao.findAll();
        list.forEach(kh -> System.out.println(kh));
         assertTrue(list.size() > 0 );
    }
    
    @Test 
    public void saveNew(){
        KhachHangDAO dao = new KhachHangDAO();
        KhachHang kh = new KhachHang();
        kh.setId(1000);
        kh.setHo("Nguyen");
        kh.setTen("Tai");
        kh.setNgaySinh(null);
        kh.setSdt("091414123");
        dao.save(kh);
        
        
    }
    @Test 
    public void update(){
        KhachHang kh = new KhachHang();
        KhachHangDAO dao = new KhachHangDAO();
        kh.setId(1000);
        kh.setHo("Nguyen");
        kh.setTen("Van Tai");
        kh.setNgaySinh(null);
        kh.setSdt("091414123");
        dao.update(kh);
        KhachHang khTest = dao.findById(1000);
        assertTrue(khTest.getTen() == "Van Tai" );
        
    }
    @Test
    public void delete(){
        KhachHangDAO dao = new KhachHangDAO();
        KhachHang khTest = dao.findById(1000);
        dao.deleteKhachHang(khTest);
        assertTrue(khTest == null);
    }
}
