package com.machi.ThreadDemo.review;

/**
 * Created by dell on 2018/2/26.
 */
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        System.out.println("thread-demo");
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        threadDemo.start();

        System.out.println("main thread");
    }

}
