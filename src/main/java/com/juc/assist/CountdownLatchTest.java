package com.juc.assist;

import java.util.concurrent.CountDownLatch;

/**
 * 计数器
 */
public class CountdownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "Go Out");
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();  //发令枪

        System.out.println("Close Door");
    }
}
