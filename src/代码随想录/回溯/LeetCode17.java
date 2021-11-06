package 代码随想录.回溯;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
public class LeetCode17 {

    List<List<Character>> lettersList = new LinkedList<>();
    List<String> result = new LinkedList<>();
    StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return result;

        for (int i = 0; i < digits.length(); i++) {
            List<Character> letters = getLetters(Character.getNumericValue(digits.charAt(i)));
            lettersList.add(letters);
        }

        int k = lettersList.size();
        backtracking(k,0);
        return result;
    }

    private void backtracking(int k, int startIndex) {
        if(path.length() == k) {
            result.add(path.toString());
            return;
        }

        for (int i = startIndex; i < lettersList.size(); i++) {
            List<Character> fistList = lettersList.get(i);
            for (Character character : fistList) {
                String s = String.valueOf(character);
                path.append(s);
                backtracking(k, i + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }


    public List<Character> getLetters(Integer digit){

        char a = 97;

        a += (digit - 2) * 3;

        if(digit == 8 || digit == 9){
            a++;
        }

        char b = (char) (a + 1);
        char c = (char) (a + 2);

        List<Character> list = new java.util.ArrayList<>(List.of(a, b, c));

        if(digit == 7 || digit == 9){
            char d = (char) (a + 3);
            list.add(d);
        }

        return list;
    }
}
