package Sof304.LabSof304;

public class MathFunc {
	public MathFunc() {
		
	}
	public long factorial(int so) {
		long ketqua=1;
		
		if(so<0||so>21) {
			throw new IllegalArgumentException("Số nhập vào không được âm và trong khoảng 0..20"); 

		}
		if(so==0||so==1) {
			ketqua =1;
			
		}
		else if(so>1) {
			for(int i=1;i<=so;i++) {
				ketqua*=i;
			}
			
		}
		return  ketqua;	
		
	}
}
