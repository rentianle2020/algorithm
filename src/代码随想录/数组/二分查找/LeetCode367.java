package 代码随想录.数组.二分查找;

/**
 * 367. 有效的完全平方数
 */
public class LeetCode367 {

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while(left <= right){
            int mid = (left + right) >> 1;
            if((long)mid * mid > num){ //这个数大了
                right = mid - 1;
            }else if((long)mid * mid < num){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
