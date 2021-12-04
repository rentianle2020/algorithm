package 多指针.区间;

import java.util.Arrays;

public class LeetCode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] res = new int[intervals.length + 1][2];
        int idx = 0;
        boolean inserted = false;

        for (int[] interval : intervals) {
            if(interval[1] < newInterval[0]){
                res[idx++] = interval;
            }else if(interval[0] > newInterval[1]){
                if(!inserted){
                    res[idx++] = newInterval;
                    inserted = true;
                }
                res[idx++] = interval;
            }else{
                newInterval[0] = Math.min(interval[0],newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
        }

        return Arrays.copyOf(res,idx);
    }
}
