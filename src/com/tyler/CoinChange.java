package com.tyler;

import java.util.Arrays;

/**
 * 找零钱问题，硬币面值&总共找零数，求最少需要几个硬币能满足找零？
 */
public class CoinChange {

    public static void main(String[] args) {
        /*int coin2 = new CoinChange().coin2(41);
        System.out.println(coin2);*/

        System.out.println(coins3(41));
        System.out.println(coins4(41,new int[]{5,10,20,21}));
    }

    /**
     * 贪婪，无法准确得到最少结果
     */
    public void coin(int totalPrice,Integer[] faces){
        Arrays.sort(faces,(Integer face1,Integer face2) -> face2 - face1);
        int coins = 0; int index = 0;
        while(index < faces.length){
            if(totalPrice < faces[index]){
                index++;
                continue;
            }
            totalPrice -= faces[index];
            coins++;
        }
        System.out.println("总共使用" + coins + "枚硬币");
    }

    /**
     * 暴力
     * 找到41-5，41-10，41-20，41-25的最优解，然后+1个硬币凑够41
     */
    public int coin2(int totalPrice){

        if(totalPrice < 1) return Integer.MAX_VALUE;
        if (totalPrice == 1 || totalPrice == 5 || totalPrice == 20 || totalPrice == 25) return 1;

        int min1 = Math.min(coin2(totalPrice - 5), coin2(totalPrice - 10));
        int min2 = Math.min(coin2(totalPrice - 20), coin2(totalPrice - 25));

        return Math.min(min1,min2) + 1;
    }

    /**
     * 递推
     * 1面值= -1的硬币数+1
     * 5面值 = -5的硬币数+1
     * ...
     * 从总额为1开始，每一步找到最优解，直到41
     */
    static int coins3(int n) {
        if(n < 1) return -1; //不存在小于1块还让找钱的
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            //如果要找面值的前比1大，就能用面值-1时的硬币数量，+1来完成找钱了
            int min = dp[i-1] + 1; //面值为41，直接2+1
            if(i >= 5) min = Math.min(dp[i-5] + 1,min);
            if(i >= 20) min = Math.min(dp[i-20] + 1,min); //面值为40，直接1+1
            if(i >= 25) min = Math.min(dp[i-25] + 1,min); //面值为25，直接0+1

            dp[i] = min;
        }
        return dp[n];
    }

    /**
     * 改进递推
     * @param n
     * @return
     */
    static int coins4(int n,int[] faces) {
        if(n < 1) return -1; //不存在小于1块还让找钱的
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            //如果要找面值的前比1大，就能用面值-1时的硬币数量，+1来完成找钱了
            for (int face : faces) {
                if(face > i) continue;
                min = Math.min(dp[i-face], min); //加上这枚面值的硬币前，共用了多少枚，最后加上这枚就行（+1）
            }

            if(min == Integer.MAX_VALUE){
                dp[i] = 0;
                continue;
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
