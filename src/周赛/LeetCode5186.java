package 周赛;

import java.util.*;

/**
 * 5186. 区间内查询数字的频率
 */
public class LeetCode5186 {


}

class RangeFreqQuery {
    Map<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            List<Integer> tmp = map.getOrDefault(arr[i], new ArrayList<>());
            tmp.add(i);
            map.put(arr[i], tmp);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> list = map.getOrDefault(value, new ArrayList<>());

        if(list.size() == 0) {
            return 0;
        }
        // System.out.println(list.toString());

        int l = binarySearchLeft(left, list);
        int r = binarySearchRight(right, list);
        if(list.get(r) < left || list.get(l) > right) {
            return 0;
        }else if(list.get(r) > right) {
            r--;
        }

        return r - l + 1;
    }
    // 找到第一个大于等于left的值
    // true o, false ., find v
    // ...voooo
    public int binarySearchLeft(int left, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while(l < r) {
            int mid = l + r >> 1;
            if(list.get(mid) >= left) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    // 找到第一个小于等于right的值
    // true o, false ., find v
    // ooooov....
    public int binarySearchRight(int right, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(list.get(mid) <= right) {
                l = mid;
            }else {
                r = mid - 1;
            }
        }

        return l;
    }

}
