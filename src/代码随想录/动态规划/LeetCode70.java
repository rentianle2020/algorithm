package 代码随想录.动态规划;

/**
 * 70. 爬楼梯
 */
public class LeetCode70 {

    public int climbStairs(int n) {

        if(n == 1 || n == 2) return n;

        int first = 1;
        int second = 2;
        int result = -1;

        for (int i = 3; i <= n ; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;

    }
}
