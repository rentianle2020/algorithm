package 代码随想录.哈希表;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 349. 两个数组的交集
 */
public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] count = new int[1000];
        ArrayList<Integer> intersection = new ArrayList<>();
        int length = 0;
        for(int num : nums1){
            count[num]++;
        }

        for(int num : nums2){
            if(count[num] != 0){
                count[num] = 0;
                intersection.add(num);
                length++;
            }
        }

        int[] res = new int[length];
        AtomicInteger index = new AtomicInteger();
        intersection.forEach(integer -> res[index.getAndIncrement()] = integer);

        return res;

    }
}
