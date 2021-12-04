package 多指针.数组;

import java.util.Arrays;

public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] temp = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;

        int p1 = 0;
        int p2 = 0;

        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                temp[index] = nums1[p1];
                p1++;
                p2++;
                index++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }else{
                p1++;
            }
        }

        return Arrays.copyOf(temp,index);
    }
}
