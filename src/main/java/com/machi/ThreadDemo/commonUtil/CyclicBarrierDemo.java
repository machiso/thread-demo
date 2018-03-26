package com.machi.ThreadDemo.commonUtil;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dell on 2018/3/26.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new Runner(cyclicBarrier,"aaa"));
        executorService.submit(new Runner(cyclicBarrier,"bbb"));
        executorService.submit(new Runner(cyclicBarrier,"ccc"));

        executorService.shutdown();
    }

    public static class Runner implements Runnable{
        private CyclicBarrier cyclicBarrier;

        private String name;

        public Runner(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000*(new Random()).nextInt(5));
                System.out.println(name + "准备ok");
                cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"GOGOGO");
        }
    }
}
