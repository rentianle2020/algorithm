package LeetCode热题;

/**
 * 31. 下一个排列
 */
public class LeetCode31 {

    public static void main(String[] args) {
        new LeetCode31().nextPermutation(new int[]{2,3,1});

    }

    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;

        int index = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] > nums[i + 1]) continue;
            index = i;
            break;
        }


        if(index != -1){
            for (int i = nums.length - 1; i > index; i--) {
                if(nums[i] > nums[index]){
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }

        for (int begin = index + 1,end = nums.length - 1; begin < end; begin++,end--) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
        }
    }
}
