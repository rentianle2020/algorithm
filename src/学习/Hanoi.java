package 学习;

/**
 * 汉诺塔
 * 一共n个盘子，ABC三个柱子
 * 每次只能挪动1个盘子，大盘子必须在小盘子下面，将n个盘子从A移动到C，需要多少步
 *
 * 思路：
 * 将n-1号从A移动到B，将第n个移动到C，然后再将（n-1）-1号从B移动到A，然后将n-1移动到C
 */
public class Hanoi {

    public static void main(String[] args) {
        hanoi(3,"A","B","C");
    }

    public static void hanoi(int n,String A,String B,String C){
        if(n == 1){
            move(n,A,C);
            return;
        }
        hanoi(n-1,A,C,B); //n-1个从A到B
        move(n,A,C);//第n个到C
        hanoi(n-1,B,A,C);//递归，剩下的n-1个将B作为起点，A作为中转，C作为目标
    }

    public static void move(int n,String from,String to){
        System.out.println(n + "号盘子，从" + from + "到" + to);
    }
}
