package com.juc.ticket;

/**
 * 窗口卖票
 */
public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "1").start();
        new Thread(ticket, "2").start();
        new Thread(ticket, "3").start();
    }

}

class Ticket implements Runnable {
    private int num = 100;

    Object obj = new Object();

    public void run() {
        synchronized (obj){
            while(true){
                if (num > 0){
                    try {
                        //睡眠容易看出多线程安全问题
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("窗口" + Thread.currentThread().getName() + "正在卖第" + num + "张票");
                    num--;
                }else {
                    break;
                }
            }
        }
    }
}
