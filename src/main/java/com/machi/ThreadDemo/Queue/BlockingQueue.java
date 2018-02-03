package com.machi.ThreadDemo.Queue;

import java.util.LinkedList;
import java.util.List;

/**
 * 实现阻塞队列
 */
public class BlockingQueue {

    private List<Object> queue = new LinkedList<>();

    private int limit = 10;

    public BlockingQueue(int limit){
        this.limit = limit;
    }

    /**
     * put操作
     * 当队列长度最大时，等待，对列长度为空时，唤醒
     */
    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit)
            wait();
        if (this.queue.size() == 0)
            notifyAll();
        this.queue.add(item);
    }

    /**
     * take操作
     */
    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0)
            wait();
        if (this.queue.size() == this.limit)
            notifyAll();
        return this.queue.remove(0);
    }

}
