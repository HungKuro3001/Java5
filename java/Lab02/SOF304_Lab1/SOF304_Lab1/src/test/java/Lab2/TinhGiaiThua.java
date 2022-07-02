package Lab2;

import java.util.Iterator;

public class TinhGiaiThua {
	int call;

	public int getCall() {
		return call;
	}

	public int tinhGiaiThua(int a) {
		this.call++;
		if (a < 0 || a > 20) {
			throw new IllegalArgumentException("Số nhập vào được nhỏ hơn 0 lớn hơn 20");
		}
		if(a == 0 || a == 1) {
			return 1;
		}
		int tong = 1;
		if (a > 1) {
			for (int i = 1; i <= a; i++) {
				tong *= i;
			}
		}
		return tong;

	}

	public long plus(int num1, int num2) {
		call++;
		return num1 + num2;
	}
}
