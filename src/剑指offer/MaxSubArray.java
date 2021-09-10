package 剑指offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class MaxSubArray {

    /**
     * 基本思路
     * 当前数+积累 < 当前数，直接拿当前数开头
     */
    public int maxSubArray(int[] nums) {
        int acc = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(acc + nums[i] < nums[i]){
                acc = nums[i];
            }else{
                acc += nums[i];
            }
            if(acc > max){
                max = acc;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * db[i]指的是以第i个数字为结尾的最大数
     */
    public int maxSubArray2(int[] nums) {
        int[] db = new int[nums.length];
        db[0] = nums[0];
        int max = db[0];
        for (int i = 1; i < nums.length; i++) {
            db[i] = Math.max(db[i - 1] + nums[i],nums[i]);
            max = Math.max(db[i],max);
        }
        return max;
    }
}
