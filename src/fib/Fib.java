package fib;

import util.TimeMachine;

/**
 * 斐波那契额数列
 */
public class Fib {

    public static void main(String[] args) {
        int n = 45;
        TimeMachine.time("normal",() -> {
            return normalFib(n);
        });
        TimeMachine.time("better",() ->{
            return betterFib(n);
        });
        TimeMachine.time("best",() ->{
            return bestFib(n);
        });
        TimeMachine.time("gundong",() ->{
            return gundongFib(n);
        });

    }

    public static int normalFib(int n){
        if(n <= 2){
            return 1;
        }
        return normalFib(n -1) + normalFib(n - 2);
    }

    public static Integer betterFib(Integer n){
        int[] list = new int[n + 1];
        list[1] = 1;
        list[2] = 1;
        return betterFib(n,list);
    }

    private static Integer betterFib(int n, int[] list) {
        if(list[n] == 0){
            list[n] = betterFib(n - 1,list) + betterFib(n - 2,list);
        }
        return list[n];
    }

    public static int bestFib(int n){
        if(n <= 2) return 1;
        int first = 1;
        int second = 1;
        for(int i = 3; i<=n; i++){
            int tempSecond = second;
            second = first + second;
            first = tempSecond;
        }
        return second;
    }

    public static int gundongFib(int n){
        int[] list = new int[2];
        list[0] = list[1] = 1;
        for (int i = 3; i <= n; i++) {
            list[i & 1] = list[0] + list[1];
        }
        return list[n & 1];
    }
}
