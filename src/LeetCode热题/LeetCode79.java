package LeetCode热题;

public class LeetCode79 {

    public boolean exist(char[][] board, String word) {

        boolean[][] used = new boolean[board.length][board[0].length];

        char start = word.charAt(0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == start){
                    used[i][j] = true;

                    if(backtracking(board,i+1,j,word,1,used)) return true;
                    if(backtracking(board,i-1,j,word,1,used)) return true;
                    if(backtracking(board,i,j + 1,word,1,used)) return true;
                    if(backtracking(board,i,j - 1,word,1,used)) return true;

                    used[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean backtracking(char[][] board,int i,int j, String word, int length,boolean[][] used) {

        if(length == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j]){
            return false;
        }

        char c = word.charAt(length);
        if(board[i][j] == c){
            used[i][j] = true;

            if(backtracking(board,i+1,j,word,length + 1,used)) return true;
            if(backtracking(board,i-1,j,word,length + 1,used)) return true;
            if(backtracking(board,i,j + 1,word,length + 1,used)) return true;
            if(backtracking(board,i,j - 1,word,length + 1,used)) return true;

            used[i][j] = false;
        }
        return false;
    }
}
