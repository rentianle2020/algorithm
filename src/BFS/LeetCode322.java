package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode322 {

    public int coinChange(int[] coins, int amount) {
        boolean[] visited = new boolean[amount + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(amount);
        int count = 0;

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                for (int coin : coins) {
                    int rest = poll - coin;
                    if(rest == 0) return count + 1;
                    if(rest > 0 && !visited[rest]){
                        queue.offer(rest);
                    }
                }
            }

            count++;
        }
        return -1;
    }
}
