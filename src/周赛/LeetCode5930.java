package 周赛;

/**
 * 5930. 两栋颜色不同且距离最远的房子
 */
public class LeetCode5930 {

    public int maxDistance(int[] colors) {

        int max = 0;

        int begin = colors[0];
        int end = colors[colors.length - 1];

        for (int i = colors.length - 1; i > 0; i--) {
            if(colors[i] != begin){
                max = i;
                break;
            }
        }

        for (int i = 0; i < colors.length - 1; i++) {
            if(colors[i] != end){
                max = Math.max(colors.length - 1 - i,max);
                break;
            }
        }

        return max;
    }
}
