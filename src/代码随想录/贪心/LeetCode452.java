package 代码随想录.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class LeetCode452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int result = 1;

        for (int i = 1; i < points.length;i++) {
            if(points[i][0] > points[i - 1][1]){
                result++;
            }else{
                points[i][1] = Math.max(points[i-1][1],points[i][1]);
            }
        }
        return result;
    }
}
