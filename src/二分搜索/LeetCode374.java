package 二分搜索;

/**
 * 374. 猜数字大小
 */
public class LeetCode374 {

    public int guessNumber(int n) {

        int begin = 1, end = n;

        while(begin <= end){

            int mid = begin + (end - begin)/2;

            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid) == 1){
                begin = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    int guess(int i){
        return 0;
    }
}
