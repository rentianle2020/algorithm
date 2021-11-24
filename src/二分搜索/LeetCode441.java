package 二分搜索;

/**
 * 441. 排列硬币
 */
public class LeetCode441 {

    public int arrangeCoins(int n) {

        int begin = 0;
        int end = n;
        int ans = -1;

        while(begin <= end){

            int mid = (begin + end) >> 1;
            if((long) mid * (mid + 1) <= (long)n * 2){
                ans = mid;
                begin = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;

    }
}
