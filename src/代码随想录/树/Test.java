package 代码随想录.树;

import util.TimeMachine;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class Test {


    public static void main(String[] args) throws IOException, InterruptedException {
        Integer[] list = new Integer[]{1,2,3,4,5};
        Arrays.sort(list,(a,b) -> b - a);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}