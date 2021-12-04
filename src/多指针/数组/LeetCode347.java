package 多指针.数组;

import java.util.*;

public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }


        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        priorityQueue.addAll(map.entrySet());

        int[] res = new int[k];
        int index = 0;

        while(index < k){
            res[index++] = priorityQueue.poll().getKey();
        }
        return res;
    }
}
