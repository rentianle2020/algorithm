package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 629. K个逆序对数组
 */
public class LeetCode629 {


    /**
     * 回溯超时！
     */
    int result = 0;

    List<Integer> path = new ArrayList<>();

    public int kInversePairs(int n, int k) {
        boolean[] used = new boolean[n + 1];
        backtracking(n,k,used,0);

        return result;
    }

    private void backtracking(int n, int k, boolean[] used,int totalInverse) {
        if(path.size() == n){
            if(totalInverse == k) {
                System.out.println(path);
                result++;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {

            int levelInverse = 0;

            if(!used[i]){
                used[i] = true;
                for (Integer integer : path) {
                    if(i < integer) levelInverse++;
                }
                path.add(i);

                backtracking(n,k,used,totalInverse + levelInverse);

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
