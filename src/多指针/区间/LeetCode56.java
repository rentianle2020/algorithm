package 多指针.区间;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode56 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[][] res = new int[intervals.length][2];

        int idx = -1;
        for (int[] interval : intervals) {
            if(idx == -1 || interval[0] > res[idx][1]){
                idx++;
                res[idx] = interval;
            }else{
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }
        }

        return Arrays.copyOf(res,idx + 1);
    }
}
