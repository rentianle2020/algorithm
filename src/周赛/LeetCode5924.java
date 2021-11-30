package 周赛;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode5924 {

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startR = startPos[0],startC = startPos[1],endR = homePos[0],endC = homePos[1];

        int ans = 0;

        for(int i = startR + 1; i <= endR; i++){
            ans += rowCosts[i];
        }

        for(int i = startR - 1; i >= endR; i--){
            ans += rowCosts[i];
        }

        for(int i = startC + 1; i <= endC; i++){
            ans += colCosts[i];
        }

        for(int i = startC - 1; i >= endC; i--){
            ans += colCosts[i];
        }
        return ans;
    }
}
