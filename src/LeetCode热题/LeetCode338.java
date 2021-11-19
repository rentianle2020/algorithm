package LeetCode热题;

/**
 * 338. 比特位计数
 */
public class LeetCode338 {

    public int[] countBits(int n) {

        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = result[i >> 2] + 1 & i;
        }

        return result;

    }

}
