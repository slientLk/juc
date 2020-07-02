package com.juc.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile
 * 保证了线程的可见性
 * 不保证原子性
 * 禁止指令重排
 */
public class VolatileDemo3 {

    //原子类的Integer
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add(){
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        //理论上num最后应该等于1000
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2){  //main  gc
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "=>" + num);
    }
}
