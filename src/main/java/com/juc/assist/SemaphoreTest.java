package com.juc.assist;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String[] args) {
        //线程数量：停车位！限流！
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();  //获取许可证
                    System.out.println(Thread.currentThread().getName() + "抢到车位");

                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开停车场");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();  //释放
                }
            },String.valueOf(i)).start();
        }
    }
}
