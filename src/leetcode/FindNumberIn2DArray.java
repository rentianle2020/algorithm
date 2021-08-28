package leetcode;

/**
 * 剑指offer 04
 */
class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int col = 0;
        int row = matrix[0].length - 1;
        while(col < matrix.length && row >= 0){
            if(matrix[col][row] == target){
                return true;
            }
            if(target < matrix[col][row]){
                row--;
            }else{
                col++;
            }
        }
        return false;
    }
}
