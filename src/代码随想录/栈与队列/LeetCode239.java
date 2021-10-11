package 代码随想录.栈与队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 239. 滑动窗口最大值
 */
public class LeetCode239 {

    private static class MyQueue{
        Deque<Integer> deque = new LinkedList<>();

            public void offer(int i){
                while(!deque.isEmpty() && deque.getLast() < i){
                    deque.removeLast();
                }
                deque.addLast(i);
            }

            public void poll(int i){
                if(!deque.isEmpty() && i == deque.peek()){
                    deque.pop();
                }
            }

            public int peek(){
                return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();

        int resultLength = nums.length - k + 1;
        int[] resultList = new int[resultLength];
        int resultIndex = 0;

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        resultList[resultIndex++] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);

            queue.offer(nums[i]);

            resultList[resultIndex++] = queue.peek();
        }

        return resultList;
    }
}
