package 多指针.数组;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class LeetCode215 {

    //二分+快排
    public int findKthLargest(int[] nums, int k) {

        int begin = 0,end = nums.length - 1;
        int target = nums.length - k;

        while(true){
            int pivot = quicksort(nums,begin,end);

            if(pivot == target) return nums[pivot];

            if(pivot > target){
                end = pivot - 1;
            }else{
                begin = pivot + 1;
            }
        }
    }

    //quick
    private int quicksort(int[] nums, int begin, int end) {

        Random random = new Random();
        int randomIndex = begin + random.nextInt(end - begin + 1);
        int temp = nums[end];
        nums[end] = nums[randomIndex];
        nums[randomIndex] = temp;
        int pivot = nums[end];

        int index = begin;

        for (int i = begin; i < end; i++) {
            if(nums[i] < pivot){
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        temp = nums[index];
        nums[index] = pivot;
        nums[end] = temp;

        return index;
    }

    //优先队列（堆）
    public int findKthLargest2(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            if (queue.size() == k) {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            } else {
                queue.offer(num);
            }
        }

        return queue.peek();
    }
}
