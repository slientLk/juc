package com.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 * put了一个元素进去，必须先从里面take出来，才能再往里面放一个元素
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>(); //同步队列

        new Thread(()->{
            try {
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + "put 1");
                queue.put("2");
                System.out.println(Thread.currentThread().getName() + "put 2");
                queue.put("3");
                System.out.println(Thread.currentThread().getName() + "put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "=>" +queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "=>" +queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "=>" +queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }

}
