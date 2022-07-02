package EduSys.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KhoaHocTestNgoaiLe {

	KhoaHoc khoaHoc;

	@Before
	public void setUp() throws Exception {
		khoaHoc = new KhoaHoc();
	}

	@After
	public void tearDown() throws Exception {
		khoaHoc = null;
	}

	@Test
	public void testMaKH_SoAm(){
		try{
			khoaHoc.setMaKH(-1);
			fail("Không bắt được ngoại lệ");
		}
		catch(IllegalArgumentException e){
			assertEquals("Ma khoc không đuọc nhỏ hơn 0", e.getMessage());
		}
	}
	@Test
	public void testMaKH_MaxGT(){
		Double Max = 999999999999999.0;
		try{
			khoaHoc.setMaKH(Integer.MAX_VALUE);
			
		}
		catch(IllegalArgumentException e){
			assertEquals("Giá trị đạt tối đa", e.getMessage());
		}

	}

}
