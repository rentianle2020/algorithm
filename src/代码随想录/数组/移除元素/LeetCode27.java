package 代码随想录.数组.移除元素;

/**
 * 27. 移除元素
 * 双指针思路，如果值!=val，快慢指针同步
 * ==val，快指针往前移，慢指针不动
 * 直到再有!=val的值出现，再同步
 * 返回慢指针下标，即为新数组长度
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex] != val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
