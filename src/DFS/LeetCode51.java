package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {

    List<List<String>> result = new ArrayList<>();
    int[] path;

    public List<List<String>> solveNQueens(int n) {

        boolean[][] board = new boolean[n][n];
        path = new int[n];

        backtrack(board,0);

        return result;
    }

    private void backtrack(boolean[][] board, int level) {
        if(level == board.length){
            result.add(generate(path));
            return;
        }

        for (int i = 0; i < board.length; i++) {

            if(!valid(board,level,i)) continue;

            board[level][i] = true;
            path[level] = i;
            backtrack(board,level + 1);
            board[level][i] = false;
        }
    }

    private List<String> generate(int[] path) {
        List<String> board  = new ArrayList<>();
        for (int j : path) {
            char[] row = new char[path.length];
            Arrays.fill(row, '.');
            row[j] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    private boolean valid(boolean[][] board, int row, int col) {

        for (int i = 0; i < row; i++) {
            if(board[i][col]) return false;
        }

        for (int i = row - 1,j = col - 1; i >=0 && j >=0 ; i--,j--) {
            if(board[i][j]) return false;
        }

        for (int i = row - 1,j = col + 1; i >=0 && j <board.length ; i--,j++) {
            if(board[i][j]) return false;
        }

        return true;
    }
}
