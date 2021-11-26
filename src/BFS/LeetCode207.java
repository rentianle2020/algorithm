package BFS;

import java.util.*;

public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        int count = 0;

        for (int[] prerequisite : prerequisites) {
            int end = prerequisite[0], begin = prerequisite[1];
            map.computeIfAbsent(begin,v -> new LinkedList<>()).add(end);
            indegree[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0){
                queue.offer(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> list = map.get(cur);
            if(list == null) continue;
            for (Integer integer : list) {
                indegree[integer]--;
                if(indegree[integer] == 0){
                    queue.offer(integer);
                    count++;
                }
            }
        }

        return count == numCourses;

    }
}
