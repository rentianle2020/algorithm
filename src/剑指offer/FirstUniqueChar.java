package 剑指offer;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符，只限小写字母
 */
public class FirstUniqueChar {

    public char firstUniqChar(String s) {
        char[] alphabet = new char[26];
        char[] chars = s.toCharArray();

        for (char c : chars) {
            alphabet[c - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if(alphabet[chars[i] - 'a'] == 1){
                return chars[i];
            }
        }
        return ' ';
    }
}
