package 每日一题;

/**
 * 495. 提莫攻击
 */
public class LeetCode495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int expire = 0;

        for (int i = 0; i < timeSeries.length; i++) {
            int poisonTime = timeSeries[i];

            if(poisonTime < expire){
                result -= expire - poisonTime;
            }
            expire = poisonTime + duration;
            result += duration;
        }
        return result;
    }
}
