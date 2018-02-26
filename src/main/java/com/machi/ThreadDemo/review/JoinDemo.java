package com.machi.ThreadDemo.review;

/**
 * Created by dell on 2018/2/26.
 */
public class JoinDemo extends Thread{

    public JoinDemo(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JoinDemo("new thread").start();
        for (int i=0;i<10;i++){
            if (i == 5){
                JoinDemo joinDemo = new JoinDemo("join thread");
                joinDemo.start();
                joinDemo.join();
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
