package LeetCode热题;

/**
 * 121. 买卖股票的最佳时机
 */
public class LeetCode121 {

    public int maxProfit(int[] prices) {

        int lowestPrice = prices[0];

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > lowestPrice){
                maxProfit = Math.max(prices[i] - lowestPrice,maxProfit);
            }else{
                lowestPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
