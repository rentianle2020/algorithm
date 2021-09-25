package 代码随想录.字符串;

/**
 * 344. 反转字符串
 */
public class LeetCode344 {


    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right){
            //swap
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
