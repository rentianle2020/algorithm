package 位运算;

/**
 * 7. 整数反转
 */
public class LeetCode7 {

    public int reverse(int x) {

        int result = 0;
        boolean isNeg = false;
        if(x < 0) {
            isNeg = true;
            x = -x;
        }

        while(x != 0){
            int digit = x % 10;
            if(result > (Integer.MAX_VALUE - digit) / 10) return 0;
            result  = result * 10 + digit;
            x /= 10;
        }

        return isNeg ? -result : result;
    }
}
