package DFS;

public class LeetCode494 {

    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {

        backtrack(nums,target,0);
        return res;
    }

    private void backtrack(int[] nums, int target, int index) {
        if(index == nums.length){
            if(target == 0) res++;
            return;
        }

        int num = nums[index];
        backtrack(nums,target + num,index + 1);
        backtrack(nums,target - num,index + 1);
    }
}
