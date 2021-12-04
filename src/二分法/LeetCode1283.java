package 二分法;

public class LeetCode1283 {

    public int smallestDivisor(int[] nums, int threshold) {

        int begin = 0,end = 1000000;

        while(begin < end){
            int mid = begin + (end - begin)/2;

            if(lessThanThreshold(mid,nums,threshold)){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return end;
    }

    private boolean lessThanThreshold(int divisor, int[] nums, int threshold) {

        int res = 0;
        for (int num : nums) {
            res += (num - 1)/divisor + 1;
            if(res > threshold) return false;
        }
        return true;
    }
}
