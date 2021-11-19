package LeetCode热题;

/**
 * 461. 汉明距离
 */
public class LeetCode461 {

    public int hammingDistance(int x, int y) {

        int value = x ^ y;

        int result = 0;

        while(value != 0){
            if((value & 1) == 1){
                result++;

            }
            value = value >> 1;
        }

        return result;
    }
}
