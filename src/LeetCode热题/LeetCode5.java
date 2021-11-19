package LeetCode热题;

/**
 * 5. 最长回文子串
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];

        int startIndex = 0;
        int endIndex = 0;
        int maxLength = 0;

        for (int right = 0 ; right < s.length(); right++) {
            for (int left = 1; left <= right; left++) {
                if(s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])){
                    dp[left][right] = true;
                    if(right - left + 1 > maxLength){
                        maxLength = right - left + 1;
                        startIndex = left;
                        endIndex = right;
                    }
                }
            }
        }

        return s.substring(startIndex,endIndex + 1);
    }
}
