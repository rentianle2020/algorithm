package BFS;

import java.util.*;

public class LeetCode126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Queue<LinkedList<String>> queue = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String s : wordList) {
            map.put(s,Integer.MAX_VALUE);
        }

        LinkedList<String> beginList = new LinkedList<>();
        beginList.add(beginWord);
        queue.offer(beginList);

        boolean found = false;
        int transform = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                LinkedList<String> path = queue.poll();
                StringBuilder sb = new StringBuilder(path.getLast());
                for (int j = 0; j < sb.length(); j++) {
                    char temp = sb.charAt(j);
                    for (char k = 'a'; k <= 'z' ; k++) {
                        sb.setCharAt(j,k);
                        String newWord = sb.toString();

                        if(map.containsKey(newWord) && map.get(newWord) >= transform){
                            map.put(newWord,transform);

                            LinkedList<String> newPath = new LinkedList<>(path);
                            newPath.add(newWord);
                            if(newWord.equals(endWord)){
                                res.add(newPath);
                                found = true;
                            }else{
                                queue.offer(newPath);
                            }
                        }
                    }
                    sb.setCharAt(j,temp);
                }
            }
            transform++;
            if(found) break;
        }
        return res;
    }
}
