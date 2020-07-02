package com.juc.thread;

/**
 * 3、添加了一个普通方法后，同一个对象，先打电话，后发短信
 * 4、两个对象，两个同步方法，先打电话，后发短信
 */
public class Thread2 {
    public static void main(String[] args) {
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
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

class Phone2 {

    //两个方法是同一个锁，谁先拿到谁先执行
    public synchronized void sendSms() {
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

    public void hello(){
        System.out.println("hello");
    }
}
