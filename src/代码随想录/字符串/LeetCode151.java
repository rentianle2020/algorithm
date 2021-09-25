package 代码随想录.字符串;

/**
 * 151. 翻转字符串里的单词
 */
public class LeetCode151 {

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length];
        int index = 0;

        int right = chars.length - 1;
        while(right >= 0 && chars[right] == ' '){
            right--;
        }

        while(right >= 0){

            //找left
            int left = right;
            while(left >= 0 && chars[left] != ' '){
                left--;
            }

            //找下一个right
            int tempRight = left - 1;
            while(tempRight >= 0 && chars[tempRight] == ' '){
                tempRight--;
            }

            left++;

            while(left <= right){
                newChars[index++] = chars[left++];
            }

            if(tempRight >= 0){
                newChars[index++] = ' ';
            }

            right = tempRight;
        }

        char[] result = new char[index];
        if (index >= 0) System.arraycopy(newChars, 0, result, 0, index);

        return new String(result);
    }
}
