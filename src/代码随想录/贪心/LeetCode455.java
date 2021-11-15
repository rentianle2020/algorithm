package 代码随想录.贪心;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {

        if(g == null || g.length == 0 || s == null || s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;

        int i = g.length - 1, j = s.length - 1;

        while(i >= 0 && j >= 0){
            if(s[j] >= g[i]){
                result++;
                i--;
                j--;
            }else{
                i--;
            }
        }
        return result;
    }
}
