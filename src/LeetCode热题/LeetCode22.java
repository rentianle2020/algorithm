package LeetCode热题;

import java.util.LinkedList;
import java.util.List;

public class LeetCode22 {

    public static void main(String[] args) {
        new LeetCode22().generateParenthesis(1);
    }

    List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {

        backtracking(n,n);

        return result;
    }

    StringBuilder stringBuilder = new StringBuilder();

    private void backtracking(int leftNum, int rightNum) {

        if(leftNum == 0 && rightNum == 0){
            result.add(stringBuilder.toString());
            return;
        }

        if(leftNum < rightNum){
            stringBuilder.append(")");
            backtracking(leftNum,rightNum - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if(leftNum != 0){
            stringBuilder.append("(");
            backtracking(leftNum - 1,rightNum);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
