package leetcode;

import java.util.*;

/**
 * 剑指offer 31
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        System.out.println(new ValidateStackSequences().validateStackSequences(new int[]{0,2,1,3}, new int[]{1,2,3,0}));
    }

    /**
     * 思路：
     * pop index下标元素后，下一个pop的只能是index - 1或者大于index的
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayList arrayList = new ArrayList<>();
        for (int push : pushed) {
            arrayList.add(push);
        }

        int beginIndex = -1;
        for (int pop : popped) {
            int index = arrayList.indexOf(pop);
            if(index == -1 || index < beginIndex) return false; //栈中找不到元素,或者比beginIndex小
            arrayList.remove(index);
            beginIndex = index - 1;
        }
        return true;
    }

    /**
     * 模拟压栈和弹栈，如果最后都能弹出，即j == popped.length，视为成功
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0; //popped[]下标，也可以视作元素个数
        for (int elem : pushed) {
            stack.push(elem);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
