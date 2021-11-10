package 代码随想录.回溯;

import 代码随想录.哈希表.LeetCode18;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
public class LeetCode17 {

    public static void main(String[] args) {
        new LeetCode17().letterCombinations("23");
    }


    List<String> result = new LinkedList<>();
    String[] letters = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuo","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return result;

        backtracking(digits,0);

        return result;
    }

    StringBuilder temp = new StringBuilder();

    private void backtracking(String digits, int index) {

        if(index == digits.length()){
            result.add(temp.toString());
            return;
        }

        String letter = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            temp.append(letter.charAt(i));
            backtracking(digits,index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
