package BFS;

import java.util.*;

public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int transform = 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);

        queue.offer(beginWord);

        while(!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                StringBuilder sb = new StringBuilder(queue.poll());

                for (int j = 0; j < sb.length(); j++) {
                    char temp = sb.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) {
                        sb.setCharAt(j,k);
                        String newWord = sb.toString();

                        if(set.contains(newWord)){
                            if(newWord.equals(endWord)) return transform + 1;
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    sb.setCharAt(j,temp);
                }
            }

            transform++;
        }
        return 0;
    }
}
