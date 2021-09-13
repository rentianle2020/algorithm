package 代码随想录.数组.滑动窗口;

/**
 * 76. 最小覆盖子串
 */
public class LeetCode76 {

    public static String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int[] need = new int[128]; //128个字符
        int count = t.length();
        int start = 0;

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++; //存放需要的char
        }
        while (right < s.length()) {
            if (need[s.charAt(right)] > 0) {
                count--;
            }
            need[s.charAt(right)]--; //重点：无论如何都让need[]--，不需要的char下标就为负了！
            if (count == 0) { //当窗口中的chars[]满足了所需的
                while (need[s.charAt(left)] < 0) { //左下标处的char多余，就挪动
                    need[s.charAt(left)]++;
                    left++;
                }
                if (right - left + 1 < minLength) { //以right结尾的串如果为最小，则更新start和minLength
                    minLength = right - left + 1;
                    start = left;
                }
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength); //截取最小覆盖串
    }
}
