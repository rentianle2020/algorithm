package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class LeetCode131 {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return result;

        backtracking(s,0);

        return result;
    }

    private void backtracking(String s, int startIndex) {

        if(startIndex == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= s.length(); i++) {

            String substring = s.substring(startIndex, i + 1);
            if(!isPalindrome(substring)) continue;

            path.add(substring);
            backtracking(s,i);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s){
        for (int i = 0, j = s.length() - 1; i < j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
