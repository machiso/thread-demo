package com.machi.ThreadDemo.review;

/**
 * Created by dell on 2018/2/26.
 */
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("runnable run-"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableDemo runnableDemo = new RunnableDemo();

        Thread thread = new Thread(runnableDemo,"Sub");

        thread.start();

        thread.join();

        System.out.println("main-thread-"+Thread.currentThread().getName());
    }
}
