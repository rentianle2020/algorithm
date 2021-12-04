package 多指针.滑动窗口;

import java.util.HashSet;

public class LeetCode3{

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        char[] chars = s.toCharArray();

        int left = 0,right = 0;
        int res = 0;

        while(right < s.length()){
            while(set.contains(chars[right])){
                set.remove(chars[left++]);
            }
            set.add(chars[right++]);
            res = Math.max(res,right - left);
        }

        return res;
    }
}
