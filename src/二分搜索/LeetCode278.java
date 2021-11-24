package 二分搜索;

/**
 * 278. 第一个错误的版本
 */
public class LeetCode278 {

    public int firstBadVersion(int n) {

        int begin = 1, end = n;

        int ans = -1;

        while(begin <= end){
            int mid = begin + (end - begin)/2;

            if(isBadVersion(mid)){
                ans = mid;
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
        }
        return ans;
    }

    private boolean isBadVersion(int mid) {

        return true;
    }
}
