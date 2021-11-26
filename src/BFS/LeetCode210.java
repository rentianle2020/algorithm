package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //邻接图
        List<List<Integer>> adjacency = new ArrayList<>();

        //入度表
        int[] indeg = new int[numCourses];

        //BFS队列
        Queue<Integer> queue = new LinkedList<>();

        //结果
        int[] res = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(0);
            indeg[prerequisite[1]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if(indeg[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            res[index++] = poll;

            List<Integer> list = adjacency.get(poll);
            for (Integer cur : list) {
                if(indeg[cur] - 1 == 0){
                    queue.offer(cur);
                }
            }
        }

        if(index != numCourses){
            return new int[0];
        }
        return res;
    }
}
