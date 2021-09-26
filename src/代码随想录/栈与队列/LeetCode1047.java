package 代码随想录.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 */
public class LeetCode1047 {

    public String removeDuplicates(String s) {

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char newChar = s.charAt(i);
            if(deque.isEmpty()){
                deque.push(newChar);
            }else{
                Character topChar = deque.peek();
                if(topChar.equals(newChar)){
                    deque.pop();
                }else{
                    deque.push(newChar);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pop());
        }
        return sb.reverse().toString();
    }
}
