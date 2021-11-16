package 代码随想录.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 */
public class LeetCode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int collapse = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= end){
                end = intervals[i][1];
            }else{
                collapse++;
                end = Math.min(end,intervals[i][1]);
            }
        }

        return collapse;
    }
}
