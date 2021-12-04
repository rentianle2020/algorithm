package 每日一题;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LeetCode506 {

    public String[] findRelativeRanks(int[] score) {

        int[] copy = Arrays.copyOf(score, score.length);
        Arrays.sort(copy);

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i],copy.length - i);
        }

        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = map.get(score[i]);
            if(rank == 1){
                result[i] = "Gold Medal";
            }else if (rank == 2){
                result[i] = "Silver Medal";
            }else if (rank == 3){
                result[i] = "Bronze Medal";
            }else{
                result[i] = String.valueOf(rank);
            }
        }
        return result;
    }
}