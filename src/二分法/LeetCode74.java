package 二分法;

public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = searchRow(matrix,target);
        int col =  searchCol(matrix,target,row);

        return matrix[row][col] == target;
    }

    private int searchCol(int[][] matrix, int target, int row) {

        int begin = 0,end = matrix[0].length - 1;
        while(begin < end){
            int mid = begin + (end - begin)/2;
            if(matrix[row][mid] >= target){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return begin;
    }

    private int searchRow(int[][] matrix, int target) {

        int begin = 0,end = matrix.length - 1;
        int length = matrix[0].length;
        while(begin < end){
            int mid = begin + (end - begin)/2;
            if(matrix[mid][length] >= target){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return begin;
    }
}
