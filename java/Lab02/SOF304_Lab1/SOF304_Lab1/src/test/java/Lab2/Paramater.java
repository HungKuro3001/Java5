package Lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class Paramater {
    int so;
    long ketquagiaithua;
    TinhGiaiThua giaithua;

	@Before
	public void setUp() throws Exception {
		giaithua = new TinhGiaiThua();
	}
	public  Paramater(int sotinh,long ketqua) {
		this.so = sotinh;
		this.ketquagiaithua = ketqua;
	}
	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] {
			{1,1},
			{2,2},
			{3,6},
			{4,24},
			{6,120},
			{6,120}
		});
	}
	@Test
	public void kiemtragiaithuavoinhieuthamso() {
		System.out.println("Tham số : thực");
		long ketqua = giaithua.tinhGiaiThua(so);
		assertEquals(ketquagiaithua, ketqua);
	}

}
