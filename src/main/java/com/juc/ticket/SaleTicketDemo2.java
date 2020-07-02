package com.juc.ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 窗口卖票
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(ticket, "1").start();
        new Thread(ticket, "2").start();
        new Thread(ticket, "3").start();
    }

}

class Ticket2 implements Runnable {
    private int num = 100;

    Lock lock = new ReentrantLock();

    public void run() {
        lock.lock();  //加锁
        try {
            //业务代码
            while (true) {
                if (num > 0) {
                    try {
                        //睡眠容易看出多线程安全问题
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("窗口" + Thread.currentThread().getName() + "正在卖第" + num + "张票");
                    num--;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  //解锁
        }
    }

}
