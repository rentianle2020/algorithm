package 代码随想录.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. 逆波兰表达式求值
 */
public class LeetCode150 {

    public static void main(String[] args) {
        new LeetCode150().evalRPN(new String[]{"4","13","5","/","+"});
    }

    public int evalRPN(String[] tokens) {
            Deque<String> deque = new ArrayDeque<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                String num1 = deque.pop(); //被除数和被减数
                String num2 = deque.pop();
                deque.push(calculate(num1, num2, s));
            } else {
                deque.push(s);
            }
        }
        return Integer.parseInt(deque.peek());
    }

    public String calculate(String num1, String num2, String operation){
        switch (operation) {
            case "+":
                return String.valueOf(Integer.parseInt(num2) + Integer.parseInt(num1));
            case "-":
                return String.valueOf(Integer.parseInt(num2) - Integer.parseInt(num1));
            case "*":
                return String.valueOf(Integer.parseInt(num2) * Integer.parseInt(num1));
            default:
                return String.valueOf(Integer.parseInt(num2) / Integer.parseInt(num1));
        }
    }
}
