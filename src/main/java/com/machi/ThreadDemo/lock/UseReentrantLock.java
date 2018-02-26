package com.machi.ThreadDemo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2018/2/26.
 */
public class UseReentrantLock implements Runnable{

    private int tickets = 100;

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try{
                lock.lock();
                if (tickets>0){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                }else {
                    System.out.println("票已经卖完！");
                    return;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        UseReentrantLock u1 = new UseReentrantLock();
        Thread t1 = new Thread(u1,"窗口1");
        Thread t2 = new Thread(u1,"窗口2");
        Thread t3 = new Thread(u1,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
