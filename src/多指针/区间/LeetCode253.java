package 多指针.区间;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode253 {

    public int minMeetingRooms(int[][] intervals) {

        List<int[]> schedule = new LinkedList<>();

        for (int[] interval : intervals) {
            schedule.add(new int[]{interval[0],1});
            schedule.add(new int[]{interval[1],-1});
        }

        schedule.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int count = 0;
        int result = 0;
        for (int[] meet : schedule) {
            count += meet[1];
            result = Math.max(result,count);
        }
        return result;
    }

    public int minMeetingRooms2(int[][] intervals) {

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];


        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int startIdx = 0;
        int endIdx = 0;
        for (int i = startIdx; i < start.length; i++) {
            if(start[i] < end[endIdx]){
                count++;
            }else{
                endIdx++;
            }
        }
        return count;
    }
}
