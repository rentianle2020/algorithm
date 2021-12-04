package DFS;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(n,n);
        return result;
    }

    private void backtrack(int left, int right) {

        if(right == 0){
            result.add(path.toString());
            return;
        }

        if(left > 0){
            path.append("(");
            backtrack(left - 1,right);
            path.deleteCharAt(path.length() - 1);
        }


        if(left < right){
            path.append(")");
            backtrack(left,right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
