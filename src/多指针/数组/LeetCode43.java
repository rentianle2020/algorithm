package 多指针.数组;

public class LeetCode43 {

    public String multiply(String num1, String num2) {

        if(num2.equals("0") || num1.equals("0")) return "0";

        int[] digits = new int[num1.length() + num2.length()];

        int carry = 0;
        for (int i = num1.length() - 1; i >= 0 ; i--) {
            for (int j = num2.length() - 1; j >= 0 ; j--) {
                int index = i + j + 1;
                int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + digits[index] + carry;

                carry = value / 10;
                digits[index] = value % 10;
            }
            if(carry != 0){
                digits[i] = carry;
                carry = 0;
            }
        }

        StringBuilder result = new StringBuilder();

        int start = 0;
        while(digits[start] == 0) start++;

        for (int i = start; i < digits.length; i++) {
            result.append(digits[i]);
        }
        return result.toString();
    }
}
