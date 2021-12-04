package 多指针.数组;

import java.util.Arrays;

public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        int[] temp = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;

        while(i < nums1.length && j < nums2.length){

            if(nums1[i] == nums2[j]){
                if(index == 0 || temp[index - 1] != nums1[i]){
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }
        }

        int[] result = Arrays.copyOf(temp, index);
        return result;
    }
}
