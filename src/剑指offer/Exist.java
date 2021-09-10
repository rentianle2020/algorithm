package 剑指offer;

/**
 * 剑指offer 12
 */
public class Exist {

    char[] letters;
    char[][] board;
    boolean[][] isVisited;

    /**
     * dfs
     */
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        this.board = board;
        this.letters = word.toCharArray();
        this.isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == letters[0]){
                    if(dfs(i,j,0)) return true;
                }

            }
        }
        return false;
    }

    public boolean dfs(int col, int row, int index){ //以col&row作为起点，找到下标为index的字母

        if(col < 0 || row < 0 || col >= board.length || row >= board[col].length || board[col][row] != letters[index] || isVisited[col][row]) return false;
        if(index == letters.length - 1) return true;
        isVisited[col][row] = true;

        boolean result =  dfs(col + 1,row,index + 1) ||
        dfs(col - 1,row,index + 1) ||
        dfs(col,row + 1,index + 1) ||
        dfs(col,row - 1,index + 1);

        isVisited[col][row] = false;
        return result;
    }
}
