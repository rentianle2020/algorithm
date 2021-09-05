package com.tyler;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().test());
    }

    public boolean test(){
        int i = 1 + 1;
        return hello() && hello();
    }

    public boolean hello(){
        return true;
    }
}
