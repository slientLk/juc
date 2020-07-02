package com.juc.lock;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义缓存
 */
public class MyCache {

    private volatile Map<String,Object> map = new HashMap<>();

    //存、写
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + "写入OK");
    }

    //取、读
    public void get(String key){
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取OK" + key);
    }
}
