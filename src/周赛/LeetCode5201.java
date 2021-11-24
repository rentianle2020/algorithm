package 周赛;

/**
 * 5201. 给植物浇水
 */
public class LeetCode5201 {

    public int wateringPlants(int[] plants, int capacity) {

        int step = 0;
        int max = capacity;


        for (int i = 0; i < plants.length; i++) {

            int waterNeed = plants[i];
            if(waterNeed > capacity){
                step += 2 * i + 1;
                capacity = max;
            }else{
                step++;
            }

            capacity -= waterNeed;
        }

        return step;
    }
}
