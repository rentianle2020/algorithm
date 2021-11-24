package LeetCode热题;

import java.util.List;

public class LeetCode139 {

    /**
     * 回溯 超时
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        return backtracking(s,0,wordDict);
    }

    private boolean backtracking(String s, int startIndex, List<String> wordDict) {

        if(startIndex == s.length()){
            return true;
        }

        StringBuilder path = new StringBuilder();

        for (int i = startIndex; i < s.length(); i++) {
            path.append(s.charAt(i));
            if(wordDict.contains(path.toString())){
                if(backtracking(s,i + 1,wordDict)) return true;
            }
        }
        return false;
    }

    /**
     * 动态规划
     */
    public boolean wordBreak2(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            for (int begin = 0; begin < end; begin++) {
                if(dp[begin] && wordDict.contains(s.substring(begin,end))){
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
