package 多指针.数组;

public class LeetCode845 {

        public int longestMountain(int[] arr) {

            if(arr.length < 3) return 0;

            int slow = 0;
            int fast = 0;

            int result = 0;

            while(fast < arr.length - 1){

                while(fast < arr.length - 1 && arr[fast + 1] < arr[fast]){
                    fast++;
                }

                if(slow == fast){
                    slow++;
                    fast++;
                    continue;
                }

                int top = fast;

                while(fast < arr.length && arr[fast + 1] > arr[fast]){
                    fast++;
                }

                if(fast == top){
                    fast++;
                    slow = fast;
                }else{
                    result = Math.max(result,fast - slow + 1);
                    slow = fast;
                }
            }
            return result;
        }
}
