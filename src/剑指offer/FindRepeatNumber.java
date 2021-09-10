package 剑指offer;

import java.util.Arrays;

/**
 * 剑指offer 03
 */
class FindRepeatNumber {


    public int findRepeatNumber(int[] nums) {

        int[] ints = new int[nums.length];
        Arrays.fill(ints,-1);
        for (int num : nums) {
            if(ints[num] != -1) return num;
            ints[num] = num;
        }
        return -1;
    }
}