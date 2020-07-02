package com.juc.assist;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 集齐七颗龙珠召唤神龙
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙成功！");
        });

        for (int i = 1; i <= 7; i++) {
            int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "收集" + temp +"个龙珠");
                try {
                    cyclicBarrier.await();  //等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
