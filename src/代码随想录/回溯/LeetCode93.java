package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 */
public class LeetCode93 {

    List<String> result = new ArrayList<>();

    int dotSize = 0;

    public List<String> restoreIpAddresses(String s) {

        if(s == null || s.length() < 4 || s.length() > 12) return result;

        backtracking(s,0);

        return result;

    }

    private void backtracking(String s, int beginIndex) {

        if(dotSize == 3){
            if(isValid(s.substring(beginIndex))) result.add(s);
            return;
        }

        for (int i = beginIndex; i < s.length() && i - beginIndex < 3; i++) {

            String substring = s.substring(beginIndex, i + 1);

            if(isValid(substring)){

                s = s.substring(0,i + 1) + "." + s.substring(i + 1);
                dotSize++;
                backtracking(s,i + 2);
                dotSize--;
                s = s.substring(0,i + 1) + s.substring(i + 2);
            }
        }
    }

    private boolean isValid(String substring) {
        if(substring == null || substring.length() == 0) return false;
        if(substring.length() > 1 && substring.startsWith("0")) return false;
        return Integer.parseInt(substring) <= 255;
    }
}
