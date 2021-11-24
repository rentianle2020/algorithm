package 二分搜索;

/**
 * 50. Pow(x, n)
 */
public class LeetCode50 {

    public double myPow(double x, int n) {

        return (long) n < 0 ? 1.0 / pow(x,-(long) n) : pow(x, n);
    }

    public double pow(double x, long n){

        if(n == 0) return 1.0;

        double res = pow(x,n/2);
        return n % 2 == 0 ? res * res : res * res * x;
    }


}
