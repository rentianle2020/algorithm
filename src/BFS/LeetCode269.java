package BFS;

import java.util.*;

public class LeetCode269 {

    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = constructGraph(words);
        if(graph == null) return "";
        return topologicalOrder(graph);

    }

    private String topologicalOrder(Map<Character, Set<Character>> graph) {

        Set<Character> set = graph.keySet();
        Map<Character,Integer> indeg = new HashMap<>();

        for (Character c : set) {
            indeg.put(c,0);
        }

        //入度表
        for (Character from : set) {
            for (Character to : graph.get(from)) {
                indeg.put(to,indeg.get(to) + 1);
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        indeg.forEach((k,v) -> {
            if(v == 0) queue.offer(k);
        });

        while(!queue.isEmpty()){
            Character poll = queue.poll();
            sb.append(poll);

            Set<Character> pollSet = graph.get(poll);
            for (Character neighbor : pollSet) {
                indeg.put(neighbor,indeg.get(neighbor) - 1);
                if(indeg.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }
        if(sb.length() != indeg.size()) return "";
        return sb.toString();
    }

    private Map<Character, Set<Character>> constructGraph(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();

        //创建节点
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                }
            }
        }

        //创建图
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int index = 0;
            while(index < word1.length() && index < word2.length()){
                char c1 = word1.charAt(index);
                char c2 = word2.charAt(index);

                if(c1 != c2){
                    graph.get(c1).add(c2);
                    break;
                }
                index++;
                if(index == Math.min(word1.length(),word2.length())){
                    if(word1.length() > word2.length()){
                        return null;
                    }
                }
            }
        }
        return graph;
    }
}
