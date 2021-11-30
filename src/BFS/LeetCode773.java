package BFS;

import java.util.*;

public class LeetCode773 {



    int[][] neighbors = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

    public int slidingPuzzle(int[][] board) {

        Set<String> visited = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        int step = 0;
        if(sb.toString().equals("123450")) return step;

        Queue<String> queue = new LinkedList<>();
        queue.offer(sb.toString());

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> list = nextStep(cur);
                for (String s : list) {
                    if(s.equals("123450")) return step + 1;
                    if(!visited.contains(s)){
                        visited.add(s);
                        queue.offer(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> nextStep(String cur) {
        List<String> res = new ArrayList<>();
        int index = cur.indexOf("0");
        char[] chars = cur.toCharArray();

        for (int nei : neighbors[index]) {
            swap(chars,index,nei);
            res.add(new String(chars));
            swap(chars,index,nei);
        }
        return res;
    }

    private void swap(char[] chars, int index1, int index2){
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}
