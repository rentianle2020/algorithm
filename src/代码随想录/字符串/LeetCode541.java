package 代码随想录.字符串;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;

/**
 * 541. 反转字符串 II
 */
public class LeetCode541 {

    public String reverseStr(String s, int k) {
        int left = 0;
        int right = k - 1;
        char[] chars = s.toCharArray();


        for (int i = 0; i < chars.length; i+=2*k) {
            left = i;
            right = (i + k - 1) > chars.length ? chars.length - 1 : i+k-1;
            while(left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return String.valueOf(chars);
    }
}
