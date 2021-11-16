package 代码随想录.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 763. 划分字母区间
 */
public class LeetCode763 {


    public List<Integer> partitionLabels(String s) {

        int[] edge = new int[26]; //最后出现的下标

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            edge[index] = Math.max(edge[index],i);
        }

        List<Integer> result = new ArrayList<>();

        int end = -1;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {

            if(i == end) {
                result.add(end - begin + 1);
                begin = i + 1;
            }

            end = Math.max(edge[s.charAt(i) - 'a'],end);
        }
        return result;
    }
}
