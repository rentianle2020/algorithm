package 每日一题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 594. 最长和谐子序列
 */
public class LeetCode594 {

    public int findLHS(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            int count = 0;
            boolean same = true;

            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == value + 1){
                    count++;
                    same = false;
                }else if(nums[j] == value){
                    count++;
                }
            }

            if(same) continue;
            max = Math.max(max,count);
        }

        return max;
    }

    public int findLHS2(int[] nums) {

        int max = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num,value + 1);
        }

        Set<Integer> integers = map.keySet();

        for (Integer integer : integers) {
            if(!map.containsKey(integer + 1)) continue;
            max = Math.max(map.get(integer) + map.get(integer + 1),max);
        }
        return max;
    }
}
