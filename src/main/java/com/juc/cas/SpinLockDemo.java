package com.juc.cas;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "=>myLock");

        //自旋锁
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    //释放锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "=>myUnLock");
        atomicReference.compareAndSet(thread,null);
    }
}
