package 周赛;

public class LeetCode5940 {

    public int minimumDeletions(int[] nums) {

        int minIndex = 0;
        int maxIndex = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < minValue){
                minValue = nums[i];
                minIndex = i;
            }

            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        int largerIndex = Math.max(minIndex, maxIndex);
        int smallerIndex = Math.min(minIndex, maxIndex);
        System.out.println(smallerIndex);
        System.out.println(largerIndex);
        return Math.min(Math.min(largerIndex + 1,nums.length - smallerIndex),smallerIndex + 1 + nums.length - smallerIndex);

    }
}
