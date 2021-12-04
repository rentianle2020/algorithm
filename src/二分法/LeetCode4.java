package 二分法;

public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            findMedianSortedArrays(nums2,nums1);
        }

        int begin = 0, end = nums1.length;
        while(begin <= end){

            int partition1 = begin + (end - begin)/2;
            //partition1 + partition2 = (nums1.length + nums2.length + 1)/2
            int partition2 = (nums1.length + nums2.length + 1)/2 - partition1;

            int left1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = partition1 == nums1.length ? Integer.MAX_VALUE : nums1[partition1];

            int left2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = partition2 == nums2.length ? Integer.MAX_VALUE : nums2[partition2];

            if(right2 >= left1 && right1 >= left2){
                if((nums1.length + nums2.length) % 2 == 0){
                    return (double)(Math.max(left1,left2) + Math.min(right1,right2))/2;
                }else{
                    return Math.max(left1,left2);
                }
            }else if(left1 > right2){
                end = partition1 - 1;
            }else{
                begin = partition1 + 1;
            }
        }
        return -1;
    }
}
