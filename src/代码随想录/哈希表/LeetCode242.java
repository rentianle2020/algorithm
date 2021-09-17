package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 有效的字母异位词
 */
public class LeetCode242 {

    public static void main(String[] args) {
        System.out.println(new LeetCode242().isAnagram2("abdc"
                , "dbac"));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer integer = hashMap.getOrDefault(s.charAt(i),0);
            hashMap.put(s.charAt(i),integer+1);
        }

        for (int i = 0; i < t.length(); i++) {
            Integer integer = hashMap.get(t.charAt(i));
            if(integer == null || integer <=0) return false;
            hashMap.put(t.charAt(i),integer -1);
        }

        return true;
    }

    /**
     * 使用简单数组
     */
    public boolean isAnagram2(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] times = new int[26];

        for(char c : s.toCharArray()){
            times[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            times[c - 'a']--;
        }

        for (int time : times) {
            if(time != 0) return false;
        }
        return true;
    }
}
