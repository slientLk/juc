package com.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS(ABA问题)
 */
public class CASDemo2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

//      ===========捣乱的线程============
        System.out.println(atomicInteger.compareAndSet(2020,2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021,2020));
        System.out.println(atomicInteger.get());

//      ===========期望的线程============
        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());
    }
}
