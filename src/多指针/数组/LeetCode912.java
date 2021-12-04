package 多指针.数组;

import java.util.Random;

public class LeetCode912 {

    public static void main(String[] args) {
        new LeetCode912().sortArray2(new int[]{5,4,3,2,1});
    }

    //quick
    public int[] sortArray(int[] nums) {

        sort(nums,0,nums.length - 1);

        return nums;
    }

    private void sort(int[] nums, int begin, int end) {

        if(end - begin < 1) return;

        int pivot = quicksort(nums,begin,end);
        sort(nums,begin,pivot - 1);
        sort(nums,pivot + 1, end);
    }

    private int quicksort(int[] nums, int begin, int end) {

        Random random = new Random();
        int randomIndex = begin + random.nextInt(end - begin + 1);
        int temp = nums[end];
        nums[end] = nums[randomIndex];
        nums[randomIndex] = temp;
        int pivot = nums[end];

        int index = begin;

        for (int i = begin; i < end; i++) {
            if(nums[i] < pivot){
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        temp = nums[index];
        nums[index] = pivot;
        nums[end] = temp;

        return index;
    }

    //merge
    public int[] sortArray2(int[] nums) {

        divide(nums,0,nums.length - 1);

        return nums;
    }

    private void divide(int[] nums, int begin, int end) {

        if(end - begin < 1) return;

        int mid = (begin + end)/2;
        divide(nums,begin,mid);
        divide(nums,mid + 1,end);

        merge(nums,begin,mid,end);
    }

    private void merge(int[] nums, int begin, int mid, int end) {

        int leftBegin = begin,leftEnd = mid,rightBegin = mid + 1,rightEnd = end;

        int[] sorted = new int[end - begin + 1];
        int index = 0;

        while(leftEnd >= leftBegin || rightEnd >= rightBegin){
            if(rightEnd >= rightBegin && (leftBegin > leftEnd || nums[rightBegin] <= nums[leftBegin])){
                sorted[index] = nums[rightBegin];
                index++;
                rightBegin++;
            }else if(rightBegin > rightEnd || nums[leftBegin] <= nums[rightBegin]){
                sorted[index] = nums[leftBegin];
                index++;
                leftBegin++;
            }
        }

        System.arraycopy(sorted,0,nums,begin,sorted.length);
    }
}
