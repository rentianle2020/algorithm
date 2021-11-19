package 学习.util;

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
