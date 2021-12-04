package 多指针.区间;

import java.util.Arrays;

public class LeetCode986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        if(firstList.length == 0 || secondList.length == 0) return new int[0][];

        int[][] result = new int[firstList.length + secondList.length][];
        int idx = 0;

        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < firstList.length && idx2 < secondList.length){
            int firstBegin = firstList[idx1][0];
            int firstEnd = firstList[idx1][1];

            int secondBegin = secondList[idx2][0];
            int secondEnd = secondList[idx2][1];

            if(secondBegin > firstEnd){
                idx1++;
            }else if(firstBegin > secondEnd){
                idx2++;
            }else{
                result[idx++] = new int[]{Math.max(firstBegin,secondBegin),Math.min(firstEnd,secondEnd)};
                if(secondEnd > firstEnd){
                    idx1++;
                }else{
                    idx2++;
                }
            }
        }

        return Arrays.copyOf(result,idx);
    }
}
