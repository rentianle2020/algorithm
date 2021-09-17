package 代码随想录.哈希表;

import java.util.HashSet;

/**
 * 快乐数
 */
public class LeetCode202 {

    public static void main(String[] args) {
        System.out.println(new LeetCode202().isHappy(182));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while(n != 1 && !hashSet.contains(n)){
            hashSet.add(n);
            n = getNextNumber(n);
        }
        return false;
    }

    public int getNextNumber(int n){
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
