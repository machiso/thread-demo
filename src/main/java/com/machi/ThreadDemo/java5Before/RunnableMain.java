package com.machi.ThreadDemo.java5Before;

/**
 * Created by dell on 2018/1/18.
 */
public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {

        RunnableThread runnableThread = new RunnableThread();

        Thread thread = new Thread(runnableThread,"Sub");

        thread.start();

        //等待线程执行完毕 串行操作
        thread.join();

        System.out.printf("[Thread:%s]Starting...\n",Thread.currentThread().getName());

        System.out.printf("runnable is completed:%s\n",runnableThread.flag);
    }

    public static class RunnableThread implements Runnable{

        private volatile boolean flag;

        @Override
        public void run() {
            System.out.printf("[Thread:%s]Starting...\n",Thread.currentThread().getName());

            flag = true;
        }

        public boolean isFlag() {
            return flag;
        }

    }
}
