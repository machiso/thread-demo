package com.machi.ThreadDemo.lock;

/**
 * Created by dell on 2018/2/26.
 */
public class DeadLock extends Thread{

    public final static Object a = new Object();
    public final static Object b = new Object();

    private boolean flag;

    public DeadLock(boolean flag){
        this.flag = flag;
    }

/*    死锁：
            两个或两个以上的线程在争夺资源的过程中，发生的一种相互等待的现象。
    举例：
            小明和小强的自行车都有两把锁一人一把钥匙案例。
            正常情况：
                小明: 两把锁的钥匙都有;
                小强: 两把锁的钥匙都有。
            现在：
                小明：有其中一把锁的两把钥匙；
                小强：有另一把锁的两把钥匙。
                结局两个人都不能打开锁。。。。一直等待朔夜起不到自行车
 */
    @Override
    public void run() {
        if (flag){
            synchronized (a){
                System.out.println("if objA");
                synchronized (b){
                    System.out.println("if objB");
                }
            }
        }else {
            synchronized (b){
                System.out.println("else objB");
                synchronized (a){
                    System.out.println("else objA");
                }
            }
        }
    }


    public static void main(String[] args) {
        DeadLock lock1 = new DeadLock(true);
        DeadLock lock2 = new DeadLock(false);
        lock1.start();
        lock2.start();
    }

}
