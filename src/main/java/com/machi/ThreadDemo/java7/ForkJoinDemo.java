package com.machi.ThreadDemo.java7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by dell on 2018/1/18.
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        //并行：多核心参与
        //并发：一同参与

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.printf("[Hello World...%s",Thread.currentThread().getName());
            }
        });

        forkJoinPool.shutdown();
    }
}
