package 代码随想录.树;

import java.io.IOException;
import java.util.Arrays;

public class Test {


    public static void main(String[] args) throws IOException, InterruptedException {
        Integer[] list = new Integer[]{1,2,3,4,5};
        Arrays.sort(list,(a,b) -> b - a);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}