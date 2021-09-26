package 代码随想录.栈与队列;

import java.util.*;

/**
 * 20. 有效的括号
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(hashMap.containsKey(c)){ //left then push
                deque.push(c);
            }else{ //right then pop left, and valid the pair
                if(deque.isEmpty()) return false;
                Character left = deque.pop();
                Character right = hashMap.get(left);
                if(!c.equals(right)) return false;
            }
        }
        return deque.isEmpty();
    }
}
