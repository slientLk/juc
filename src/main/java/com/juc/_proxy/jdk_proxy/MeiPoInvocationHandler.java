package com.juc._proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MeiPoInvocationHandler implements InvocationHandler {

    private Object object;

    public MeiPoInvocationHandler(Object object) {
        this.object = object;
    }

    /**
     *
     * @param proxy  代理对象的引用
     * @param method 被代理对象的方法
     * @param args   被代理对象方法被调用时传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(object, args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("我是媒婆：我要给你找对象，现在已经拿到你的需求，开始物色对象");
    }

    private void after() {
        System.out.println("如果合适的话，就准备办事");
    }

}
