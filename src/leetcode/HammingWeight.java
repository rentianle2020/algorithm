package leetcode;

/**
 * 剑指offer 15
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag)!=0){
                count++;
            }
            flag <<= 1;

        }
        return count;
    }
}
