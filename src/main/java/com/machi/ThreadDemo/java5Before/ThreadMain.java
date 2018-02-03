package com.machi.ThreadDemo.java5Before;

/**
 * Created by dell on 2018/1/18.
 */
public class ThreadMain {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("[Thread:%s]Starting...\n",Thread.currentThread().getName());
            }
        },"Sub");

        thread.start();

        System.out.printf("[Thread:%s]Starting...\n",Thread.currentThread().getName());

    }
}
