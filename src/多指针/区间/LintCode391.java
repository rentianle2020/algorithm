package 多指针.区间;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LintCode391 {

    public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

    public int countOfAirplanes(List<Interval> airplanes) {

        List<int[]> schedule = new ArrayList<>();

        for (Interval airplane : airplanes) {
            schedule.add(new int[]{airplane.start,1});
            schedule.add(new int[]{airplane.end,-1});
        }

        schedule.sort((a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else{
                return a[0] - b[0];
            }
        });

        int count = 0;
        int res = 0;

        for (int[] ints : schedule) {
            count += ints[1];
            res = Math.max(res, count);
        }
        return res;
    }
}
