package 多指针.回文串;

public class LeetCode680 {

    public boolean validPalindrome(String s) {

        int begin = 0,end = s.length() -1;

        while(begin < end){
            if(s.charAt(begin) != s.charAt(end)) break;
        }
        if(begin >= end) return true;

        return isPalin(s,begin + 1,end) || isPalin(s,begin,end - 1);
    }

    private boolean isPalin(String s,int begin,int end){
        while(begin < end){
            if(s.charAt(begin) != s.charAt(end)) return false;
            begin++;
            end--;
        }
        return true;
    }
}
