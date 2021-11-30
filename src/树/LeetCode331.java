package 树;

import java.util.*;

public class LeetCode331 {

    public boolean isValidSerialization(String preorder) {

        int count = 0;

        char[] chars = preorder.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {

            if(chars[i] == ',') continue;

            if(chars[i] == '#'){
                count++;
            }else{
                while(i > 0 && Character.isDigit(chars[i - 1])) i--;

                if(count >= 2){
                    count -= 1;
                }else{
                    return false;
                }
            }
        }

        return count == 1;
    }

}
