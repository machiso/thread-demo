package com.machi.ThreadDemo.review;

import java.util.concurrent.*;

/**
 * Created by dell on 2018/2/26.
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        CallableThread callableThread = new CallableThread();

        Future<String> future = executorService.submit(callableThread);

        String s = future.get();

        System.out.println("s::"+s);

        executorService.shutdown();

        System.out.println("main-thread");
    }

    static class CallableThread implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("thread-name:"+Thread.currentThread().getName());
            return "Callable-Thread";
        }
    }
}
