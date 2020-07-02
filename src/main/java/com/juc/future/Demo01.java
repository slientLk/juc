package com.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的 runAsync 异步回调
        /*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "runAsync=>Void");
        });
        System.out.println("1111111111");
        completableFuture.get();  // 获取阻塞执行结果*/

        // 有返回值的 supplyAsync 异步回调
        // ajax，成功和失败的回调
        // 返回的是错误信息；
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync=>Integer");
            int i = 1 / 0;
            return 1024;
        });
        System.out.println(completableFuture.whenComplete((t,u)->{
            System.out.println("t=>" + t);  //正常返回结果
            System.out.println("u=>" + u);  //错误信息
        }).exceptionally(e -> {
            System.out.println(e.getMessage());  //可以获取到错误的返回结果
            return 2333;
        }).get());
    }
}
