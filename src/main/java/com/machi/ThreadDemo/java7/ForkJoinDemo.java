package com.machi.ThreadDemo.java7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by dell on 2018/1/18.
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        //并行：多核心参与
        //并发：一同参与

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<Integer> list = Arrays.asList(1,2,23,53,3,4,5,6,7,8,32,9,10);

        //累加数
        LongAdder longAdder = new LongAdder();

        MyTask task = new MyTask(list,longAdder);

        forkJoinPool.invoke(task);

        System.out.println(longAdder);
        forkJoinPool.shutdown();

    }

    public static class MyTask extends RecursiveAction{

        private final List<Integer> nums;
        private final LongAdder longAdder;

        public MyTask(List<Integer> nums, LongAdder longAdder) {

            this.nums = nums;
            this.longAdder = longAdder;
        }

        @Override
        protected void compute() {

            int size  =nums.size();
            if (size > 1){
                //得到中位数
                int offset = size/2;

                List<Integer> leftPart = nums.subList(0, offset);

                MyTask leftTask = new MyTask(leftPart, longAdder);

                List<Integer> rightPart = nums.subList(offset, size);

                MyTask rightTask = new MyTask(rightPart,longAdder);

                invokeAll(leftTask,rightTask);

            }else {
                if (size == 0){
                    return;
                }

                Integer integer = nums.get(0);
                longAdder.add(integer.longValue());
            }

        }
    }
}
