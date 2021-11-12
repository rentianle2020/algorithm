package 代码随想录.回溯;

import java.util.Arrays;

/**
 * 37. 解数独
 */
public class LeetCode37 {

    public static void main(String[] args) {
        char[][] chars = new char[9][9];
        for (char[] aChar : chars) {
            Arrays.fill(aChar,'.');
        }
        new LeetCode37().solveSudoku(chars);
    }

    public void solveSudoku(char[][] board) {

        backtracking(0,board);

    }

    private boolean backtracking(int beginRow,char[][] board) {

        for (int i = beginRow; i < 9; i++) { //遍历列
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') continue;

                for (char k = '1'; k <= '9'; k++) {
                    if(isValid(i,j,k,board)){
                        board[i][j] = k;
                        if(backtracking(i,board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char c, char[][] board) {

        //上
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == c) return false;
        }

        //左
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == c) return false;
        }

        //同9格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == c) return false;
            }
        }

        return true;
    }
}
