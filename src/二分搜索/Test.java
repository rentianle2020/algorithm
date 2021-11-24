package 二分搜索;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.PriorityQueue;
import java.util.Set;

public enum Test {

    GOOD_INFO("nice"),BAD_INFO("no!"),
    NOT_EXIST_INFO{
        @Override
        String getInfo() {
            throw new IllegalArgumentException("INFO NOT EXIST");
        }
    };

    String info;
    Test(){}
    Test(String info) {
        this.info = info;
    }
    String getInfo(){
        return info;
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    int id();
    String description() default "";
}

class Ok extends AbstractProcessor {

    @MyAnnotation(id = 1)
    public void okok(){

    }

    @MyAnnotation(id = 2)
    public void notok(){

    }

    public static void main(String[] args) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{4,4});
        pq.offer(new int[]{3,3});
        pq.offer(new int[]{2,3});
        pq.offer(new int[]{1,3});

        for (int i : pq.poll()) {
            System.out.println(i);
        }
    }

    public static void processor(Class<?> c){
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            if(annotation != null){
                System.out.println(annotation.id() + ":" + annotation.description());
            }
        }
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            System.out.println(annotation);
        }

        return false;
    }
}


