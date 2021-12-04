package DFS;

import java.util.ArrayList;
import java.util.List;

public class LeetCode301 {

    List<String> result = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int removeLeft = 0;
        int removeRight = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                removeLeft++;
            }else if(s.charAt(i) == ')'){
                if(removeLeft > 0){
                    removeLeft--;
                }else{
                    removeRight++;
                }
            }
        }

        backtrack(s,removeLeft,removeRight,0);

        return result;

    }

    private void backtrack(String s, int removeLeft, int removeRight, int start) {
        if(removeLeft == 0 && removeRight == 0){
            if(valid(s)){
                result.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(i > 0 && s.charAt(i) == s.charAt(i - 1)) continue;

            if(removeLeft + removeRight > s.length() - i) return;
            //try to removeLeft
            if(s.charAt(i) == '(' && removeLeft > 0){
                backtrack(s.substring(0,i) + s.substring(i + 1),removeLeft - 1,removeRight,i);
                continue;
            }

            //try to removeRight
            if(s.charAt(i) == ')' && removeRight > 0){
                backtrack(s.substring(0,i) + s.substring(i + 1),removeLeft,removeRight - 1,i);
            }
        }
    }

    private boolean valid(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                left++;
            }else if(s.charAt(i) == ')'){
                if(left == 0) return false;
                left--;
            }
        }
        return true;
    }
}
