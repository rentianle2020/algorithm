package BFS;

import java.util.*;


class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}

public class LintCode127 {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {

        Map<DirectedGraphNode,Integer> indegree = new HashMap<>();

        for(DirectedGraphNode node : graph){
            if(!indegree.containsKey(node)){
                indegree.put(node,0);
            }

            for (DirectedGraphNode neighbor : node.neighbors) {
                if(!indegree.containsKey(neighbor)){
                    indegree.put(neighbor,0);
                }

                indegree.put(neighbor,indegree.get(neighbor) + 1);
            }

        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        ArrayList<DirectedGraphNode> res = new ArrayList<>();

        Set<DirectedGraphNode> keys = indegree.keySet();
        for (DirectedGraphNode key : keys) {
            if(indegree.get(key) == 0) queue.offer(key);
        }

        while(!queue.isEmpty()){
            DirectedGraphNode poll = queue.poll();
            res.add(poll);

            for (DirectedGraphNode neighbor : poll.neighbors) {
                indegree.put(neighbor,indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }

        return res;
    }
}
