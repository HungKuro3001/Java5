package Lab04;

public class VatCaCulator {
    public static double getVat(double price) {
        if (price < 5000000&& price >0) {
            return price * 0.05;
        } else if (price < 10000000) {
            return price * 0.1;
        } else if (price < 18000000) {
            return price * 0.15;
        } else if(price<32000000){
            return price * 0.2;
        }else if (price <52000000) {
            return price * 0.25;
        } else if(price<80000000){
            return price * 0.3;
        }else{
            return price * 0.35;
        }
    }
}

