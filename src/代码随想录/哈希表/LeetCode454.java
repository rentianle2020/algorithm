package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 454. 四数相加 II
 */
public class LeetCode454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums1){
            for (int j : nums2) {
                int sum = i + j;
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum) + 1);
                }else{
                    map.put(sum,1);
                }
            }
        }

        for(int i : nums3){
            for (int j : nums4) {
                int need = -(i + j);
                if(map.containsKey(need)){
                    count += map.get(need);
                }
            }
        }
        return count;
    }
}
