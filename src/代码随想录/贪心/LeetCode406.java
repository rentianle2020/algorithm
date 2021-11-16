package 代码随想录.贪心;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * 406. 根据身高重建队列
 */
public class LeetCode406 {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });

        System.out.println(people);
        LinkedList<int[]> list = new LinkedList<>();

        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(people);
    }
}
