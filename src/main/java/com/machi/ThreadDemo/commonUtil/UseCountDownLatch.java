package com.machi.ThreadDemo.commonUtil;

import java.util.concurrent.CountDownLatch;

/**
 * 一个计数器初始化设置一个初始值，countDown调用await方法。
 * 每调用一次countDown（）方法内部计数器减1，直到减到0时唤醒。
 * Created by dell on 2018/3/26.
 */
public class UseCountDownLatch {
    public static void main(String[] args) {

        final CountDownLatch countDown = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程t1" + "等待其他线程处理完成...");
                    countDown.await();
                    System.out.println("t1线程继续执行...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t2线程进行初始化操作...");
                    Thread.sleep(3000);
                    System.out.println("t2线程初始化完毕，通知t1线程继续...");
                    countDown.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t3线程进行初始化操作...");
                    Thread.sleep(4000);
                    System.out.println("t3线程初始化完毕，通知t1线程继续...");
                    countDown.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();



    }
}
