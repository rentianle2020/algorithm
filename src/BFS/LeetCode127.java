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


    /**
     * 双向BFS
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        int transform = 1;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        beginSet.add(beginWord);
        endSet.add(endWord);


        while(!beginSet.isEmpty() && !endSet.isEmpty()) {

            Set<String> nextSet = new HashSet<>();

            for (String word : beginSet) {
                StringBuilder sb = new StringBuilder(word);

                for (int j = 0; j < sb.length(); j++) {
                    char temp = sb.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) {
                        sb.setCharAt(j,k);
                        String newWord = sb.toString();

                        if(words.contains(newWord) && visited.add(newWord)){
                            if(endSet.contains(newWord)) return transform + 1;
                            nextSet.add(newWord);
                        }
                    }
                    sb.setCharAt(j,temp);
                }
            }

            if(endSet.size() < nextSet.size()){
                beginSet = endSet;
                endSet = nextSet;
            }

            transform++;
        }
        return 0;
    }
}
