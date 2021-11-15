package 代码随想录.贪心;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class LeetCode122 {

    public int maxProfit(int[] prices) {

        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int dayProfit = prices[i + 1] - prices[i];

            if(dayProfit > 0){
                profit += dayProfit;
            }
        }
        return profit;
    }
}
