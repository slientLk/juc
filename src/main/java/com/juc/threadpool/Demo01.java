package com.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池 3大方法 七大参数 四种拒绝策略
 */
public class Demo01 {

    public static void main(String[] args) {
        //Executors 工具类3大方法

        ExecutorService threadPool = Executors.newSingleThreadExecutor();  //单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);    //创建一个固定大小的线程池
//        ExecutorService threadPool = Executors.newCachedThreadPool();    //可伸缩，遇强则强，遇弱则弱

        try {
            for (int i = 0; i < 100; i++) {
                //使用了线程池之后，使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }

}
