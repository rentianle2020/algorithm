package 多指针.数组;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LeetCode42 {

    public int trap(int[] height) {

        LinkedList<Integer> stack = new LinkedList<>();

        int res = 0;

        for (int i = 0; i < height.length; i++) {

            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int base = height[stack.pop()];

                if(stack.isEmpty()) break;

                int leftIndex = stack.peek();
                int high = Math.min(height[i],height[leftIndex]);
                int width = i - leftIndex - 1;

                res += (high - base) * width;
            }
            stack.push(i);
        }

        return res;
    }
}
