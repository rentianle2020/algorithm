package 周赛;

import java.util.*;

public class LeetCode5941 {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        List<Integer> res = new ArrayList<>();

        boolean[] visited = new boolean[n];
        int curTime = 0;
        //建图
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] meeting : meetings) {
            int first = meeting[0],second = meeting[1],time = meeting[2];
            graph.get(first).add(new int[]{second,time});
            graph.get(second).add(new int[]{first,time});
        }

        //PQ
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s[1]));
        List<int[]> startList = graph.get(firstPerson);
        for (int[] start : startList) {
            queue.offer(start);
        }
        List<int[]> startList2 = graph.get(0);
        for (int[] start : startList2) {
            queue.offer(start);
        }
        res.add(firstPerson);
        visited[firstPerson] = true;
        res.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int time = poll[1];
            if(visited[poll[0]]) continue;
            if(time >= curTime) {
                visited[poll[0]] = true;
                res.add(poll[0]);
                curTime = time;
                List<int[]> next = graph.get(poll[0]);
                for (int[] specialist : next) {
                    if (!visited[specialist[0]]) {
                        queue.offer(specialist);
                    }
                }
            }
        }
        return res;
    }
}
