package 代码随想录.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 */
class MyStack {

    Queue<Integer> queue1; //输入队列
    Queue<Integer> queue2; //保存队列

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }
}
