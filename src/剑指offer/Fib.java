package 剑指offer;

/**
 * 剑指offer 10-1
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(new Fib().fib(48));
    }

    public int fib(int n) {
        int first = 0;
        int second = 1;
        if(n == 0) return first;
        if(n == 1) return second;
        for(int i = 2;i<=n;i++){
            int tempSecond = second % 1000000007;
            second = (first + second) % 1000000007;
            first = tempSecond;
        }
        return second ;
    }
}
