package 多指针.回文串;

import java.util.HashSet;
import java.util.Locale;

public class LeetCode345 {

    public static void main(String[] args) {
        new LeetCode345().reverseVowels("hello");
    }

    public String reverseVowels(String s) {

        int begin = 0,end = s.length() - 1;

        char[] letters = s.toCharArray();

        while(begin < end){

            while(begin < letters.length && !isVowel(letters[begin])){
                begin++;
            }

            while(end >= 0 && !isVowel(letters[end])){
                end--;
            }

            if(begin < end){
                char temp = letters[begin];
                letters[begin] = letters[end];
                letters[end] = temp;

                begin++;
                end--;
            }
        }

        return new String(letters);
    }

    private boolean isVowel(char letter) {
        return "aeiouAEIOU".indexOf(letter) != -1;
    }
}
