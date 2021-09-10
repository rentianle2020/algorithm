package 剑指offer;

/**
 * 剑指offer 11
 */
public class MinArray {

    public static void main(String[] args) {
        new MinArray().minArray2(new int[]{2,2,2,0,1});
    }

    /**
     * 暴力
     */
    public int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        return min;
    }

    /**
     * 二分搜索 需要考虑的情况略多
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        if(numbers.length == 1 || numbers[numbers.length -1] > numbers[0]) return numbers[0];
        int front = 0;
        int end = numbers.length -1;
        while(front + 1 < end){
            int mid = (front + end) >> 1;
            if(numbers[mid] > numbers[end]){
                front = mid;
            }else if(numbers[mid] < numbers[end]){
                end = mid;
            }else{
                end--; //去重
            }
        }
        return numbers[end];
    }
}
