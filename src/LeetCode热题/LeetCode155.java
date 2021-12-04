package LeetCode热题;

import java.util.LinkedList;
import java.util.List;

public class LeetCode155 {


}

/**
 * 155. 最小栈
 */
class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
    }

    int min = Integer.MAX_VALUE;
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();

    public MinStack() {
    }

    public void push(int val) {

        stack.push(val);

        if(val <= min){
            minStack.push(val);
            min = val;
        }
    }

    public void pop() {
        int pop = stack.pop();

        if(pop == minStack.peek()){
            minStack.pop();
            min = stack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
