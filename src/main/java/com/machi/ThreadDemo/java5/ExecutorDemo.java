package com.machi.ThreadDemo.java5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dell on 2018/1/18.
 */
public class ExecutorDemo {

    public static void main(String[] args) {

        //执行器  线程池(ThreadPoolExecutor)是他的一种实现
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.printf("[Thread:%s]Starting...\n",Thread.currentThread().getName());
            }
        });

        executor.shutdown();
    }

}
