package com.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;


public class CASDemo3 {

    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(1, 1);

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("a1=>" + stampedReference.getStamp());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stampedReference.compareAndSet(1, 2,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println("a2=>" + stampedReference.getStamp());

            System.out.println(stampedReference.compareAndSet(2, 1,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1));
            System.out.println("a2=>" + stampedReference.getStamp());
        }, "a").start();

        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println("b1=>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(stampedReference.compareAndSet(1, 6,
                    stamp, stamp + 1));
            System.out.println("b2=>" + stampedReference.getStamp());
        }, "b").start();
    }
}
