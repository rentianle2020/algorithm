package 周赛;

import java.util.HashMap;
import java.util.Set;

public class LeetCode5922 {

    public int countWords(String[] words1, String[] words2) {

        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();

        for (String s : words1) {
            map.put(s,map.getOrDefault(s,0) + 1);
        }

        for (String s : words2) {
            map2.put(s,map2.getOrDefault(s,0) + 1);
        }

        Set<String> strings = map.keySet();

        int res = 0;

        for (String string : strings) {
            if(map.get(string) == 1 && map2.getOrDefault(string,0) == 1){
                res++;
            }
        }

        return res;
    }
}
