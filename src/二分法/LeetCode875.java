package 二分法;

import java.util.Arrays;

public class LeetCode875 {

    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();

        int begin = 1,end = max;
        while(begin < end){
            int mid = begin + (end - begin)/2;
            if(finishEating(piles,h,mid)){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }

        return begin;
    }

    private boolean finishEating(int[] piles, int h, int speed) {

        for (int pile : piles) {
            while(pile > 0){
                pile -= speed;
                if(h == 0) return false;
                h--;
            }
        }
        return true;
    }
}
