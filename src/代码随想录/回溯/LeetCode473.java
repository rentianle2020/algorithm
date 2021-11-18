package 代码随想录.回溯;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 */
public class LeetCode473 {

    int[] side = new int[4];

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }

        if(sum % 4 != 0) return false;

        int target = sum / 4;
        Arrays.fill(side,target);
        Arrays.sort(matchsticks);

       return backtracking(matchsticks,matchsticks.length - 1);

    }

    private boolean backtracking(int[] matchsticks, int curIndex) {

        if(curIndex <0) return true;

        for (int i = 0; i < 4; i++) {
            if(side[i] == matchsticks[curIndex] || side[i] - matchsticks[curIndex] >= matchsticks[0]){
                side[i] -= matchsticks[curIndex];
                if(backtracking(matchsticks,curIndex - 1)) return true;
                side[i] += matchsticks[curIndex];
            }
        }

        return false;
    }
}
