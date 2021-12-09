package 数据结构.数组;

public class LeetCode48 {

    public void rotate(int[][] matrix) {
        //[3][1] --> [1][0]; [3][2] --> [2][0]
        //[row][col] --> [col][length - row - 1]
        //[row][col] --> [col][row] --> [col][length - row - 1]

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                swap(matrix,i,j,j,i);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length/2; j++) {
                swap(matrix,i,j,i,matrix.length - j - 1);
            }
        }
    }

    private void swap(int[][] matrix,int row1,int col1,int row2,int col2){
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
}
