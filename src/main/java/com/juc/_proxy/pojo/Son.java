package com.juc._proxy.pojo;

import com.juc._proxy.dao.Person;

/**
 * 被代理对象
 */
public class Son implements Person {

    @Override
    public void findLove() {
        System.out.println("儿子要求：肤白貌美大长腿");
    }
}
