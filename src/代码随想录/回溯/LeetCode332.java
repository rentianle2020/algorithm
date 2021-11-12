package 代码随想录.回溯;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * 332. 重新安排行程
 */
public class LeetCode332 {



    Map<String, TreeMap<String, Integer>> map = new HashMap<>();

    List<String> result = new LinkedList<>();

    int cityNumber = 0;

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if(map.containsKey(from)){
                TreeMap<String, Integer> toList = map.get(from);
                if(toList.containsKey(to)){
                    toList.put(to,toList.get(to) + 1);
                }else{
                    toList.put(to,1);
                }
            }else{
                TreeMap<String, Integer> treeMap = new TreeMap<>();
                treeMap.put(to,1);
                map.put(from,treeMap);
            }
        }

        result.add("JFK");
        cityNumber = tickets.size() + 1;

        backtracking(map, "JFK");

        return result;
    }

    private boolean backtracking(Map<String, TreeMap<String, Integer>> map, String startFlight) {

        if (result.size() == cityNumber) {
            return true;
        }

        if(!map.containsKey(startFlight)) return false;

        TreeMap<String, Integer> toList = map.get(startFlight);

        for (Map.Entry<String, Integer> to : toList.entrySet()) {

            if (to.getValue().equals(0)) continue;

            result.add(to.getKey());
            to.setValue(to.getValue() - 1);
            if (backtracking(map, to.getKey())) return true;
            to.setValue(to.getValue() + 1);
            result.remove(result.size() - 1);

        }

        return false;
    }
}
