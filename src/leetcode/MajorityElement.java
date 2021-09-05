package leetcode;

import java.util.Random;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement2(new int[]{1,2,3,2,2,2,5,4,2}));
    }


    public int majorityElement(int[] nums) {

        int num = nums[0];
        int times = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == num){
                times++;
            }else{
                if((times - 1) > 0){
                    times--;
                }else{
                    num = nums[i];
                }
            }
        }
        return num;
    }

    public int majorityElement2(int[] nums) {

        int begin = 0;
        int end = nums.length - 1;
        int mid = (begin + end) >> 1;
        int pivot = partition(begin, end, nums);
        while(pivot != mid){
            if(pivot < mid){
                begin = pivot+1;
            }else{
                end = pivot-1;
            }
            pivot = partition(begin,end,nums);
        }
        return nums[mid];
    }

    private int partition( int lo, int hi,int[] nums){
        int num = nums[lo];
        int i =lo,j=hi+1;
        while(true){
            while(i<hi && nums[++i]<num);
            while(j>lo && nums[--j]>num);
            if(i>=j) break;
            swap(nums,i,j);
        }
        swap(nums,lo,j);
        return j;
    }
    private void swap(int[]nums, int i ,int j ){
        int temp = nums[i];nums[i] = nums[j];nums[j] = temp;
    }
}
