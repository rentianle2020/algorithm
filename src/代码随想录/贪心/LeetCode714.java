package 代码随想录.贪心;

public class LeetCode714 {

    public int maxProfit(int[] prices, int fee) {

        int buy = prices[0] + fee;
        int profit = 0;

        for (int price : prices) {
            if(price + fee < buy){ //找到最新买入点，先把fee加上
                buy = price + fee;
            }else if (price > buy){ //更高的价格，直接卖，更新当前买入点（比这个price还高，再接着赚）
                profit += price - buy;
                buy = price;
            }
        }

        return profit;
    }
}
