package 多指针.数组;

public class LeetCode75 {

    public void sortColors(int[] nums) {

        int zero = 0;
        int one = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                swap(nums,one,i);
                one++;
            }else if(nums[i] == 0){
                swap(nums,zero,i);
                if(nums[i] == 1){
                    swap(nums,one,i);
                }
                zero++;
                one++;
            }
        }
    }

    private void swap(int[] nums, int one, int i) {
        int temp = nums[one];
        nums[one] = nums[i];
        nums[i] = temp;
    }
}
