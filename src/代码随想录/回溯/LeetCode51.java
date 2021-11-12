package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 */
public class LeetCode51 {

    List<List<String>> result = new ArrayList<>();

    List<String> path;


    public List<List<String>> solveNQueens(int n) {

        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars,'.');
        }

        backtracking(0,chessboard);

        return result;
    }

    private void backtracking(int row, char[][] chessboard) {

        if(row == chessboard.length){
            path = new ArrayList<>();
            for (char[] c : chessboard) {
                path.add(new String(c));
            }
            result.add(path);
            return;
        }

        for (int col = 0; col < chessboard.length; col++) {
            if(isValid(row,col,chessboard)){

                chessboard[row][col] = 'Q';
                backtracking(row + 1,chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] chessboard) {

        //上面
        for (int i = 0; i < row; i++) {
            if(chessboard[i][col] == 'Q') return false;
        }

        //左45度
        for (int i = row - 1,j=col - 1; i >= 0 && j >= 0 ; i--,j--) {
            if(chessboard[i][j] == 'Q') return false;
        }

        //右45度
        for (int i = row - 1,j=col + 1; i >= 0 && j < chessboard.length ; i--,j++) {
            if(chessboard[i][j] == 'Q') return false;
        }

        return true;
    }
}
