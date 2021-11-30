package 周赛;

import java.util.Arrays;

public class LeetCode5939 {

    public int[] getAverages(int[] nums, int k) {

        int begin = 0;
        int end = 2 * k;
        int target = k;

        int[] res = new int[nums.length];
        long sum = 0;
        int count = 2 * k + 1;

        if(end > nums.length - 1) {
            Arrays.fill(res, -1);
            return res;
        }

        for (int i = 0; i < k; i++) {
            res[i] = -1;
        }

        for (int i = nums.length - 1; i >= nums.length - k ; i--) {
            res[i] = -1;
        }


        for (int i = begin; i <= end; i++) {
            sum += nums[i];
        }
        res[target] = (int)(sum / count);
        while(end + 1< nums.length){
            sum -= nums[begin++];
            sum += nums[++end];
            System.out.println(sum);
            res[++target] = (int)(sum / count);
        }
        return res;
    }
}
