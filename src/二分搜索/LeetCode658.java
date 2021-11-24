package 二分搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 */
public class LeetCode658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int begin = 0, end = arr.length - k;
        int ans = 0;

        while(begin <= end){

            if(begin == arr.length - k){
                ans = begin;
                break;
            }

            int mid = begin + (end - begin)/2;

            if(x - arr[mid] <= arr[mid + k] - x){
                ans = mid;
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
        }

        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < k; i++){
            res.add(arr[ans]);
            ans++;
        }

        return res;
    }
}
