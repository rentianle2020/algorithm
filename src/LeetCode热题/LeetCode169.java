package LeetCode热题;

/**
 * 169. 多数元素
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {

        int count = 0;

        int major = 0;

        for (int num : nums) {
            if (count == 0) {
                major = num;
                count++;
            } else {
                count = num == major ? count + 1 : count - 1;
            }
        }

        return major;
    }
}
