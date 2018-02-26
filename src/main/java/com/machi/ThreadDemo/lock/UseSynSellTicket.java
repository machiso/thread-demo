package com.machi.ThreadDemo.lock;

/**
 * Created by dell on 2018/2/26.
 */
public class UseSynSellTicket implements Runnable{

    private static int ticket = 100;

    Object object = new Object();

    @Override
    public void run() {
        while (true)
            synchronized (object){
                if (ticket>0){
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--) + "张票");
                }else {
                    System.out.println("票已经卖完！");
                    return;
                }
            }
    }

    public static void main(String[] args) {
        UseSynSellTicket u1 = new UseSynSellTicket();
        Thread t1 = new Thread(u1,"窗口1");
        Thread t2 = new Thread(u1,"窗口2");
        Thread t3 = new Thread(u1,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
