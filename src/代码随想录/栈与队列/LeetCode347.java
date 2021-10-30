package 代码随想录.栈与队列;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 */
public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int num : nums){
            frequency.put(num,frequency.getOrDefault(num,0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = frequency.entrySet();

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : entries) {
            priorityQueue.offer(entry);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = priorityQueue.poll().getKey();
        }
        return result;
    }
}
