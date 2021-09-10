package 剑指offer;

/**
 * 剑指offer 21
 */
public class Exchange {

    public static void main(String[] args) {
        int[] exchange = new Exchange().exchange(new int[]{5, 3, 2, 4, 1, 3, 4});
        for (int i = exchange.length - 1; i >= 0; i--) {
            System.out.println(exchange[i]);
        }
    }

    int[] nums;

    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        this.nums = nums;

        int front = 0;
        int end = nums.length - 1;
        while(front < end){
            while(front + 1 < nums.length && nums[front] % 2 == 1){
                front++;
            }
            while(end > 0 && nums[end] % 2 == 0){
                end--;
            }
            if(front < end){
                swap(front,end);
            }
        }
        return nums;
    }

    public void swap(int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
