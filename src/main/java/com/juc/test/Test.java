package com.juc.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(()->{
            System.out.println("call()");
            return 1024;
        });

        new Thread(task,"A").start();
        new Thread(task,"B").start();

        System.out.println(task.get());
    }
}
