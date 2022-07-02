public class Bai1 {
    public static int function(int n) {
        if (n == 0) {
            return 4;
        } else if(n == 1) {
            return 7;

        }else if(n == 2) {
            return 5;
        }else {
            return function(n-1) + function(n-2) + function(n-3);
        }
    }

    public static void main(String[] args) {
        System.out.println(function(5));
    }
}
