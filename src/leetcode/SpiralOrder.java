package leetcode;

/**
 * 剑指offer 29
 */
public class SpiralOrder {

    /**
     *从左向右走，走完之后top+1
     * 从上往下走，走完之后right-1
     * 从右往左走，走完之后bottom - 1
     * 从下往上走，走完之后left - 1
     */
    public int[] spiralOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0) return new int[0];

        int colLength = matrix.length;
        int rowLength = matrix[0].length;

        int index = 0;
        int total = colLength * rowLength;
        int[] spiral = new int[total];

        int top = 0, bottom = colLength - 1, left = 0, right = rowLength - 1;
        while(true){
            for (int lr = left; lr <= right; lr++) {
                spiral[index] = matrix[top][lr];
                index++;
                if(index == total) return spiral;
            }
            top++;

            for (int tb = top; tb <= bottom; tb++) {
                spiral[index] = matrix[tb][right];
                index++;
                if(index == total) return spiral;
            }
            right--;

            for (int rl = right; rl >= left; rl--) {
                spiral[index] = matrix[bottom][rl];
                index++;
                if(index == total) return spiral;
            }
            bottom--;

            for (int bt = bottom; bt >= top; bt--) {
                spiral[index] = matrix[bt][left];
                index++;
                if(index == total) return spiral;
            }
            left++;
        }
    }
}
