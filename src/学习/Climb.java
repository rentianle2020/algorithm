package 学习;

import 学习.util.TimeMachine;

/**
 * 爬楼梯，每次可以爬1阶或2阶台阶，多少种爬法到n阶
 *
 * 思路：
 * 爬到n-1的所有方法，都可以作为爬到n的方法，因为都+1步就到了
 * 爬到n-2的所有方法，也都可以作为爬到n的方法，因为都+2步就到了
 * 所以爬到n的方法数量，等于爬到n-1，和爬到n-2阶的方法之和
 * n-1和n-2的目的地都不一样，所以不会重合
 */

public class Climb {

    public static void main(String[] args) {
        TimeMachine.time("climb",() ->{
            return climb(10);
        });
    }

    public static int climb(int level){
        /*if(level == 1) return 1;
        if(level == 2) return 2;*/
        if(level <= 2) return level;
        return climb(level - 1) + climb(level - 2);
    }
}
