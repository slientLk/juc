package com.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 队列四组API
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1(){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
//        System.out.println(queue.add("d"));

        System.out.println("====================");

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //Exception in thread "main" java.util.NoSuchElementException
        System.out.println(queue.remove());
    }

    /**
     * 有返回值，无异常
     */
    public static void test2(){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("c"));
        System.out.println(queue.offer("c"));
        System.out.println(queue.offer("d"));  //false

        System.out.println("=====================");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());  //null
    }

    /**
     * 等待，一直阻塞
     * @throws InterruptedException
     */
    public static void test3() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("d");  //没有位置了，一直阻塞

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
//        System.out.println(queue.take());  //没有元素了，一直阻塞
    }

    /**
     * 等待，阻塞（等待超时）
     * @throws InterruptedException
     */
    public static void test4() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
//        System.out.println(queue.offer("d", 2, TimeUnit.SECONDS));  //等待超过两秒就退出

        System.out.println("===========");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.poll(2, TimeUnit.SECONDS);  //等待超过两秒就退出
    }
}
