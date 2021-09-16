package 代码随想录.数组;

import java.util.HashMap;
import java.util.HashSet;

public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer rest = hashMap.get(target - nums[i]);
            if(rest != null){
                if(rest == i) continue;
                return new int[]{i,rest};
            }
        }
        return null;
    }
}
