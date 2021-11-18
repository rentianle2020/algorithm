package 代码随想录.动态规划;

/**
 * 343. 整数拆分
 */
public class LeetCode343 {

    public int integerBreak(int n) {

        int[] db = new int[n + 1];

        db[2] = 1;

        for (int i = 3; i <= n; i++) {

            for (int j = 1 ; j < i; j++) {
                db[i] = Math.max(db[i],Math.max(j * (i - j),j * db[i - j]));
            }
        }
        return db[n];
    }
}
