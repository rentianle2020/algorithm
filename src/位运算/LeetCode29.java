package 位运算;

public class LeetCode29 {

    public static void main(String[] args) {
        new LeetCode29().divide(-2147483648,1);
    }

    public int divide(int dividend, int divisor) {

        //溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }


        //全部转负，防止溢出
        boolean isNeg = true;
        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0){
            isNeg = false;
        }

        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int ans = 0;

        while(dividend >= divisor){

            int temp = divisor;
            int count = 1;

            while(temp <= dividend - temp){
                temp += temp;
                count += count;
            }

            dividend -= temp;
            ans += count;
        }

        return isNeg ? -ans : ans;
    }
}
