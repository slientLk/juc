package com.juc.thread;

/**
 * 7、一个静态同步方法，一个普通同步方法，一个对象，先打电话，后发短信
 * 8、一个静态同步方法，一个普通同步方法，两个对象，先打电话，后发短信
 */
public class Thread4 {
    public static void main(String[] args) {
        //两个对象的Class类模板只有一个，锁的是Class
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();
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

class Phone4 {

    //静态方法锁的是类对象
    public static synchronized void sendSms() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}
