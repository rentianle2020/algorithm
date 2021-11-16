package 代码随想录.贪心;

import java.util.stream.IntStream;

/**
 * 135. 分发糖果
 */
public class LeetCode135 {

    public int candy(int[] ratings) {

        int[] candyNum = new int[ratings.length];
        candyNum[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]){
                candyNum[i] = candyNum[i - 1] + 1;
            }else{
                candyNum[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0 ; i--) {
            if(ratings[i] > ratings[i + 1]){
                candyNum[i] = candyNum[i + 1] + 1;
            }
        }

        return IntStream.of(candyNum).sum();
    }
}
