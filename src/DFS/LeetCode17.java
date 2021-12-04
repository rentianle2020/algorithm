package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LeetCode17 {

    char[][] phone = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'}
            ,{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {


        if(digits.equals("")) return result;

        backtrack(digits.toCharArray(),0);

        return result;
    }

    private void backtrack(char[] digits, int index) {

        if(index == digits.length){
            result.add(path.toString());
            return;
        }

        int number = Character.getNumericValue(digits[index]);
        char[] chars = phone[number];

        for (char aChar : chars) {
            path.append(aChar);
            backtrack(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
