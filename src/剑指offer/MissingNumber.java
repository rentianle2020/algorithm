package 剑指offer;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber2(new int[]{0, 1, 3, 4, 5}));
    }

    /**
     * 遍历
     */
    public int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i) return i;
            i++;
        }
        return i;
    }

    /**
     * 二分
     */
    public int missingNumber2(int[] nums) {
        int begin = 0,end = nums.length - 1;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(nums[mid] != mid){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return begin;
    }
}
