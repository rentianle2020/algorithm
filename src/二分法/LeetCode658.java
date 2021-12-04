package 二分法;

import java.util.LinkedList;
import java.util.List;

public class LeetCode658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            res.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if(Math.abs(res.get(0) - x) > Math.abs(arr[i] - x)){
                res.remove(0);
                res.add(arr[i]);
            }else if(Math.abs(res.get(0) - x) < Math.abs(arr[i] - x)){
                break;
            }
        }
        return res;
    }
}
