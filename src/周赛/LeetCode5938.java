package 周赛;

import java.util.ArrayList;
import java.util.List;

public class LeetCode5938 {

    public List<Integer> targetIndices(int[] nums, int target) {

        int num = 0;
        int less = 0;
        for (int i : nums) {
            if(i < target){
                less++;
            }else if(i == target){
                num++;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            res.add(less++);
        }
        return res;
    }
}
