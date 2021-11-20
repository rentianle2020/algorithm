package LeetCode热题;

/**
 * 75. 颜色分类
 */
public class LeetCode75 {

    public static void main(String[] args) {
        new LeetCode75().sortColors(new int[]{2,0,2,1,1,0});
    }

    /**
     * 插入排序
     */
    public void sortColors(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            int index = i;
            while(index > 0 && nums[i] < nums[index - 1]){
                index = index - 1;
            }

            if(index != i ){
                int temp = nums[i];
                for (int j = i; j > index; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[index] = temp;
            }
        }
    }

    public void sortColors2(int[] nums) {

        int red = 0;
        int white = 0;
        int blue = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) red++;
            else if(nums[i] == 1) white++;
            else blue++;
        }

        for (int i = 0; i < nums.length; i++) {
            if(red != 0){
                nums[i] = 0;
                red--;
            }else if(white != 0){
                nums[i] = 1;
                white--;
            }else{
                nums[i] = 2;
            }
        }
    }

    /**
     * 双指针
     */
    public void sortColors3(int[] nums) {

        int point0 = 0;
        int point1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){

            }
        }
    }
}
