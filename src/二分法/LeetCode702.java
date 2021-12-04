package 二分法;

interface ArrayReader {

    public int get(int index);

}

public class LeetCode702 {

    public int search(ArrayReader reader, int target) {

        int begin = 0,end = Integer.MAX_VALUE;

        while(begin <= end){
            int mid = begin + (end - begin)/2;
            if(reader.get(mid) == target) return mid;

            if(reader.get(mid) > target){
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
        }
        return -1;
    }
}
