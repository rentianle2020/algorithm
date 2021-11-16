package 代码随想录.贪心;

/**
 * 134. 加油站
 */
public class LeetCode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalRest = 0;
        int currentRest = 0;

        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            totalRest += rest;
            currentRest += rest;

            if(currentRest < 0){
                currentRest = 0;
                startIndex = i + 1;
            }
        }

        if(totalRest < 0) return -1;
        return startIndex;
    }
}
