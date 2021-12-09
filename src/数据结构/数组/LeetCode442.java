package 数据结构.数组;

import java.util.ArrayList;
import java.util.List;

public class LeetCode442 {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            int n = Math.abs(num);
            if(nums[n - 1] < 0) res.add(n);
            else nums[n - 1] *= -1;
        }

        return res;
    }
}
