package com.juc.jmm;

/**
 * volatile
 * 保证了线程的可见性
 * 不保证原子性
 * 禁止指令重排
 */
public class VolatileDemo {

    private volatile static boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (flag){
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;
        System.out.println(flag);
    }
}
