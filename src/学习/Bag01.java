package 学习;

public class Bag01 {

    public static void main(String[] args) {
        int[] values = new int[]{6,3,5,4,6};
        int[] weights = new int[]{2,2,6,5,4};
        int capacity = 10;
        System.out.println(new Bag01().bag2(values, weights,capacity));
    }


    public int bag(int[] values, int[] weights,int capacity){
        int[][] dp = new int[capacity + 1][values.length + 1]; //初始化dp
        int maxValue = 0;
        for (int weight = 1; weight <= capacity; weight++) {
            for (int value = 1; value <= values.length; value++) {
                //不选
                int drop = dp[weight][value - 1];
                if(weights[value - 1] > weight){
                    dp[weight][value] = drop;
                    continue;
                }
                //选
                int choose = dp[weight - weights[value - 1]][value - 1] + values[value - 1];
                dp[weight][value] = Math.max(drop,choose);
                maxValue = Math.max(dp[weight][value],maxValue);
            }
        }
        return maxValue;
    }

    /**
     * 简化为一维数组，画一个矩阵就明白了
     */
    public int bag2(int[] values, int[] weights,int capacity){
        int[] dp = new int[capacity + 1]; //初始化dp
        int maxValue = 0;
        for (int v = 1; v <= values.length; v++) {
            for (int w = capacity; w >= 1 ; w--) {
                /*int drop = dp[w];*/
                if(weights[v - 1] > w) continue; //自动drop
                int choose = dp[w-weights[v - 1]] + values[v - 1];
                dp[w] = Math.max(choose,dp[w]);
                maxValue = Math.max(dp[w],maxValue);
            }
        }
        return maxValue;
    }
}
