package 二分法;

public class LeetCode69 {

    public int mySqrt(int x) {

        int begin = 0,end = x;

        while(begin < end){
            int mid = begin + (end - begin)/2 + 1;
            if((double)mid * mid <= x){
                begin = mid;
            }else{
                end = mid - 1;
            }
        }

        return begin;
    }
}
