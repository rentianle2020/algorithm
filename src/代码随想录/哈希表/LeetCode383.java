package 代码随想录.哈希表;

import java.util.HashMap;

/**
 * 383. 赎金信
 */
public class LeetCode383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] charTimes = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            charTimes[c - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(charTimes[c] > 0){
                charTimes[c]--;
            }else{
                return false;
            }
        }


        return true;
    }
}
