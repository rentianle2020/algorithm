package BFS;

import java.util.*;

public class LeetCode133 {

    public Node cloneGraph(Node node) {

        Map<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        map.put(node,new Node(node.val));

        queue.offer(node);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            List<Node> neighbors = poll.neighbors;

            for (Node neighbor : neighbors) {
                if(!map.containsKey(neighbor)){
                    queue.offer(neighbor);
                    map.put(neighbor,new Node(neighbor.val));
                }
                map.get(poll).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
