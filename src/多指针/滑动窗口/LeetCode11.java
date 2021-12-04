package 多指针.滑动窗口;

public class LeetCode11 {

    public int maxArea(int[] height) {
        int begin = 0,end = height.length - 1;

        int res = 0;

        while(begin < end){
            int high = Math.min(height[begin],height[end]);
            int width = end - begin;

            res = Math.max(res,high * width);

            if(height[begin] < height[end]){
                begin++;
            }else{
                end--;
            }
        }
        return res;
    }
}
