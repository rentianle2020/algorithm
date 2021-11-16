package 代码随想录.动态规划;

/**
 * 509. 斐波那契数
 */
public class LeetCode509 {

    int first;
    int second;

    public int fib(int n) {
        if(n == 1 || n == 0) return n;

        first = 0;
        second = 1;
        for (int i = 2; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }

        return second;
    }
}
