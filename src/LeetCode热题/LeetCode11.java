package LeetCode热题;

/**
 * 11. 盛最多水的容器
 */
public class LeetCode11 {

    public int maxArea(int[] height) {

        int result = 0;

        int start = 0;
        int end = height.length - 1;

        while(start != end){
            int min = Math.min(height[start],height[end]);
            result = Math.max((end - start) * min,result);

            if(height[start] == min){
                start++;
            }else{
                end--;
            }
        }

        return result;
    }
}
