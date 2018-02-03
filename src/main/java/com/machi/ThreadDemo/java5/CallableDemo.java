package com.machi.ThreadDemo.java5;

import java.util.concurrent.*;

/**
 * Created by dell on 2018/1/18.
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello World";
            }
        });

        String result = future.get();
        System.out.println(result);
        executor.shutdown();
    }
}
