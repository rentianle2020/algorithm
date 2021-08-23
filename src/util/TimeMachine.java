package util;

import com.sun.org.apache.xpath.internal.operations.Minus;

import java.time.LocalTime;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TimeMachine {

    public static void time(String functionName,Supplier supplier){
        System.out.println("方法名：" + functionName);
        double before = System.currentTimeMillis();
        Object result = supplier.get();
        double after = System.currentTimeMillis();
        double time = after - before;
        System.out.println("方法结果：" + result);
        System.out.println("用时：" + time/1000 + "秒");
        System.out.println("---------------");
    }
}
