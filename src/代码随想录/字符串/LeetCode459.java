package 代码随想录.字符串;

/**
 * 459. 重复的子字符串
 */
public class LeetCode459 {

    //https://stackoverflow.com/questions/55823298/how-do-i-check-if-a-string-is-entirely-made-of-the-same-substring/55840779#55840779
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
