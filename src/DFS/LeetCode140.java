package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode140 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("11").append(" ");
        System.out.println(sb.toString());
    }

    List<String> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);
        backtrack(s,set,0);
        return result;
    }

    private void backtrack(String s, HashSet<String> set,int startIndex) {
        if(startIndex == s.length()){
            result.add(construct(s,path));
            return;
        }

        if(startIndex != 0) path.add(startIndex);
        for (int i = startIndex; i < s.length(); i++) {
            if(set.contains(s.substring(startIndex,i + 1))){
                backtrack(s,set,i + 1);
            }
        }
        path.remove(path.size() - 1);
    }

    private String construct(String s, List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        int begin = 0;
        for (Integer integer : path) {
            sb.append(s, begin, integer).append(" ");
            begin = integer;
        }
        sb.append(s, begin,s.length());
        return sb.toString();
    }
}
