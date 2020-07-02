package com.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        System.out.println(atomicInteger.compareAndSet(2020,2021));
        System.out.println(atomicInteger.get());

        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.compareAndSet(2020, 2020));
        System.out.println(atomicInteger.get());
    }
}
