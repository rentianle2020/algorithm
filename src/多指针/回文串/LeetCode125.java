package 多指针.回文串;

public class LeetCode125 {

    public boolean isPalindrome(String s) {

        char[] letters = s.toCharArray();
        int begin = 0,end = s.length() - 1;

        while(begin < end){
            while(begin < s.length() && !Character.isLetterOrDigit(letters[begin])){
                begin++;
            }

            while(end >= 0 && !Character.isLetterOrDigit(letters[end])){
                end--;
            }

            if(begin < end){

                if(Character.toUpperCase(letters[begin]) != Character.toUpperCase(letters[end])) return false;

                begin++;
                end--;
            }
        }
        return true;
    }
}
