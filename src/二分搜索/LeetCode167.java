package 二分搜索;

import java.util.HashMap;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {

        int begin = 0, end = numbers.length - 1;


        while(begin < end){
            int sum = numbers[begin] + numbers[end];

            if(sum == target){
                return new int[]{begin + 1,end + 1};
            }else if (sum < target){
                begin++;
            }else{
                end--;
            }
        }
        return null;
    }
}
