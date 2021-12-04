package 二分法;

public class LeetCode278 {

    public int firstBadVersion(int n) {

        int begin = 1,end = n;

        while(begin < end){
            int mid = begin + (end - begin)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return begin;
    }

    boolean isBadVersion(int version){
        return true;
    }
}
