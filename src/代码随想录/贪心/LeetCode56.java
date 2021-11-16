package 代码随想录.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1],end);
            }else{
                list.add(new int[]{begin,end});
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{begin,end});

        return list.toArray(new int[list.size()][]);
    }
}
