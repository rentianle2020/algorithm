package 剑指offer;

/**
 * 剑指offer 16
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(8.84372 ,-5));
    }

    /**
     * 暴力，时长不通过
     */
    public double myPow2(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        int abs = Math.abs(n);
        double base = x;
        for (int i = 2; i <= abs; i++) {
            x *= base;
        }
        if(n < 0){
            x = 1/x;
        }
        return x;
    }

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;

        double result = myPow(x, n / 2);
        result *= result;
        if((n & 1) == 1){
            result *= n < 0 ? 1/x : x;
        }

        return result;

    }
}
