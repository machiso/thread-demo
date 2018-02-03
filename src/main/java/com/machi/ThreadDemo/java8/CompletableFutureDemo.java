package com.machi.ThreadDemo.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by dell on 2018/1/19.
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = new CompletableFuture<String>();

        //设值 完成操作（可以被其他线程去做）
        completableFuture.complete("Hello World");

        String result = completableFuture.get();

        System.out.println(result);
    }
}
