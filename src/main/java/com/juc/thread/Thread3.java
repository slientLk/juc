package com.juc.thread;

/**
 * 5、两个静态同步方法，一个对象，先发短信，再打电话
 * 6、两个静态同步方法，两个对象，还是先发短信，再打电话
 */
public class Thread3 {
    public static void main(String[] args) {
        //两个对象的Class类模板只有一个，锁的是Class
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();
        new Thread(() -> {
            phone1.sendSms();
        }, "A").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.call();
        }, "B").start();
    }
}

class Phone3 {

    //两个方法是同一个锁，谁先拿到谁先执行
    public static synchronized void sendSms() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }
}
