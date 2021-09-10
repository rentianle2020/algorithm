package 剑指offer;

/**
 * 剑指 Offer 40. 最小的k个数
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] sort = countingSort(arr);
        int[] result = new int[k];
        System.arraycopy(sort, 0, result, 0, k);
        return result;

    }

    public int[] countingSort(int[] arr){
        int[] counting = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            counting[j]++;
        }

        int index = 0;
        for (int i = 0; i < counting.length; i++) {
            while(counting[i] != 0){
                counting[i]--;
                arr[index] = i;
                index++;
            }
        }
        return arr;
    }


}
