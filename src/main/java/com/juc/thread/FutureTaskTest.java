package com.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Thread只接受Runnable,FutureTask实现了Runnable接口，故可以将FutureTask传入Thread中
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new Thread().start();  //怎么启动callable

        FutureTask futureTask = new FutureTask(new MyThread());  //适配类

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();  //结果会被缓存，效率高

        Integer result = (Integer) futureTask.get(); //这个方法可能会阻塞！把他放到最后

        //或者调用异步通信来处理
        System.out.println(result);
    }


}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() {
        System.out.println("call()");  //会打印几个call
        //耗时的操作
        return 1024;
    }
}
