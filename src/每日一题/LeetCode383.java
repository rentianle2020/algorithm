package 每日一题;

public class LeetCode383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()) return false;

        int[] frequency = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            frequency[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            frequency[c - 'a']--;
            if(frequency[c - 'a'] < 0) return false;
        }
        return true;
    }
}
