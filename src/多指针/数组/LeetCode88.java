package 多指针.数组;

public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(m == 0){
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }
        if(n == 0) return;

        int p1 = m - 1, p2 = n - 1;
        int tail = nums1.length - 1;

        while(tail >= 0){
            if(p1 < 0){
                nums1[tail--] = nums2[p2--];
            }else if(p2 < 0 || nums1[p1] >= nums2[p2]){
                nums1[tail--] = nums1[p1--];
            }else{
                nums1[tail--] = nums2[p2--];
            }
        }
    }
}
