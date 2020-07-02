package com.juc.jmm;

/**
 * volatile
 * 保证了线程的可见性
 * 不保证原子性
 * 禁止指令重排
 */
public class VolatileDemo2 {

    private volatile static int num = 0;

    public static void add(){
        num++;  //不保证原子性
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
