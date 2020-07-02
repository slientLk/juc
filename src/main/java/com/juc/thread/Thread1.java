package com.juc.thread;

/**
 * 8锁  关于锁的8个问题
 * 1、标准情况下 先发短信 再打电话
 * 2、sendSms延迟4秒后 还是先发短信 再打电话
 */
public class Thread1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.call();
        }, "B").start();
    }
}

class Phone {

    //两个方法是同一个锁，谁先拿到谁先执行
    public synchronized void sendSms() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
        call();
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}
