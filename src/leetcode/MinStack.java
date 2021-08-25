package leetcode;

/**
 * 剑指offer 30
 */
class MinStack {

    Integer[] stack;
    Integer[] minStack;
    int size;
    int minSize;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Integer[10000];
        minStack = new Integer[1000];
        size = 0;
        minSize = 0;
    }

    public void push(int x) {
        stack[size++] = x;
        if(minSize == 0 || x <= minStack[minSize - 1]){
            minStack[minSize++] = x;
        }
    }

    public void pop() {
        if(size == 0) return;
        if(stack[size - 1].equals(minStack[minSize - 1])){
            minSize--;
        }
        stack[size - 1] = null;
        size--;

    }

    public int top() {
        if(size == 0) return -1;
        return stack[size - 1];
    }

    public int min() {
        if(minSize == 0) return -1;
        return minStack[minSize - 1];
    }
}
