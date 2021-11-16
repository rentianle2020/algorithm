package 代码随想录.贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * 738. 单调递增的数字
 */
public class LeetCode738 {
    public static void main(String[] args) {
        char b = '9';
        char c = (char) (Character.getNumericValue(b) - 1 + '0');
        System.out.println(c);
    }

    public int monotoneIncreasingDigits(int n) {

        char[] chars = Integer.toString(n).toCharArray();

        int index = 0;
        int max = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i] > max){
                index = i;
                max = chars[i];
            }

            if (chars[i] > chars[i + 1]) {
                chars[index] = (char) (Character.getNumericValue(chars[index]) - 1 + '0');
                for (int j = index + 1; j < chars.length; j++) {
                    chars[j] = '9';
                }
            }
        }

        return Integer.parseInt(new String(chars));
    }
}
