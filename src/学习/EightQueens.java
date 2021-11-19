package 学习;

/**
 * 八皇后问题
 * 64个各自摆放8个皇后，让他们不能互相攻击（攻击范围横竖斜）
 *
 * 思路
 * 回溯，一行一行摆放，不行了就回到上一行重新摆放
 */
public class EightQueens {

    public static void main(String[] args) {
        new EightQueens().queens(8);
        new EightQueens().queens(4);
    }

    public int[] cols; //下标代表行，值代表列; int[1] = 3，代表在第2行的第4个放了皇后

    public int ways;

    public int size;

    public boolean[] rows;
    public boolean[] topRight;
    public boolean[] topLeft;

    void queens(int n){
        size = n;
        cols = new int[n];
        rows = new boolean[n];
        topRight = new boolean[n * 2];
        topLeft = new boolean[n * 2];
        place(0);
        System.out.println("共有" + ways + "种组合方式");
    }

    public void place(int col) {
        if (col >= cols.length) {
            ways++;
            printWay();
        }
        for (int row = 0; row < cols.length; row++) {
            int tl = col - row + size - 1;
            int tr = col + row;
            if (rows[row]) continue;
            if (topRight[tr]) continue;
            if (topLeft[tl]) continue;
            cols[col] = row; //如果合法，就放皇后
            rows[row] = true;
            topRight[tr] = true;
            topLeft[tl] = true;
            place(col + 1); //下一行
            rows[row] = false; //回溯，将之前设定的限制（剪枝）都去掉
            topRight[tr] = false;
            topLeft[tl] = false;
        }
    }

    public void printWay(){
        for (int col : cols) {
            for (int j = 0; j < cols.length; j++) {
                if (col != j) System.out.print(0 + "\t");
                else System.out.print(1 + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }
}
