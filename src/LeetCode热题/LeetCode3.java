package LeetCode热题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class LeetCode3 {

    /**
     * Map滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int index = 0; index < s.length(); index++) {

            char c = s.charAt(index);

            if(map.containsKey(c)){
                left = Math.max(left,map.get(c) + 1);
            }
            map.put(c,index);
            max = Math.max(max,index - left + 1);
        }

        return max;
    }

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring2(String s){
        Set<Character> set = new HashSet<>();

        char[] chars = s.toCharArray();

        int current = 0;
        int result = 0;

        for (int start = 0,end = 0; end < chars.length; end++) {
            if(set.contains(chars[end])){
                while(chars[start] != chars[end]){
                    set.remove(chars[start]);
                    start++;
                }
                start++;

                current = end - start + 1;
            }else{
                set.add(chars[end]);
                current++;
                result = Math.max(result,current);
            }
        }
        return result;
    }
}
