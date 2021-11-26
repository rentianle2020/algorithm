package BFS;

import java.util.*;

public class LeetCode444 {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        Map<Integer,Integer> indegree = new HashMap<>();
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for (List<Integer> seq : seqs) {
            for (int i = 1; i < seq.size() - 1; i++) {
                int first = seq.get(i);
                int second = seq.get(i + 1);

                if(!indegree.containsKey(first)) indegree.put(first,0);
                if(!indegree.containsKey(second)) indegree.put(second,0);

                graph.computeIfAbsent(first, l -> new ArrayList<>()).add(second);
                indegree.put(second,indegree.get(second) + 1);
            }
            indegree.putIfAbsent(seq.get(seq.size() - 1),0);
        }
        if(indegree.size() != org.length) return false;

        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[org.length];
        int index = 0;

        indegree.forEach((k,v) -> {
            if(v == 0) queue.offer(k);
        });

        while(!queue.isEmpty()){
            if(queue.size() != 1) return false;

            Integer poll = queue.poll();
            if(index == res.length) return false;
            System.out.println(poll);
            res[index++] = poll;

            for (Integer neighbor : graph.getOrDefault(poll,new ArrayList<>())) {
                indegree.put(neighbor,indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }
        for (int re : res) {
            System.out.println(re);
        }

        return Arrays.equals(res, org);

    }
}
