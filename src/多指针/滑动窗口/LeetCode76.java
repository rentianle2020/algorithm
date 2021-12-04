package 多指针.滑动窗口;

import java.util.HashMap;

public class LeetCode76 {

    public static void main(String[] args) {
        new LeetCode76().minWindow("ADOBECODEBANC"
                ,"ABC");
    }

    public String minWindow(String s, String t) {

        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char wanted = t.charAt(i);
            map.put(wanted,map.getOrDefault(wanted,0) + 1);
        }

        int count = t.length(),validCount = 0;

        int left = 0,right = 0;

        int beginIndex = 0,length = Integer.MAX_VALUE;

        while(right < s.length()){

            char newChar = s.charAt(right);
            if(map.containsKey(newChar)){
                map.put(newChar,map.get(newChar) - 1);
                if(map.get(newChar) >= 0){
                    validCount++;
                }
            }
            right++;

            while(validCount == count){
                if(right - left + 1 < length){
                    beginIndex = left - 1;
                    length = right - beginIndex;
                }

                char leftChar = s.charAt(left++);
                if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar) + 1);
                    if(map.get(leftChar) > 0) {
                        validCount--;
                    }
                }
            }

        }
        return length == 0 ? "" : s.substring(beginIndex,beginIndex + length);
    }
}
