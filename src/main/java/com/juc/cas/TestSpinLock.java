package com.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class TestSpinLock {

    public static void main(String[] args) throws InterruptedException {
        //底层使用的自旋锁
        SpinLockDemo lock = new SpinLockDemo();

        new Thread(()->{
            lock.myLock();

            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        },"A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            lock.myLock();   //不断自旋看A释放了锁没

            try {
                System.out.println("11111111111");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        },"B").start();
    }
}
