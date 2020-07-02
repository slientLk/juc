package com.juc._iterator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class IteratorTest {

    public static void main(String[] args) {
        /*ArrayList<String> list = new ArrayList<>();
        list.add("C++");
        list.add("PHP");
        list.add("JAVA");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String s = it.next();
            if ("JAVA".equals(s)){
//                list.remove(s);  //会产生并发异常，因为只会在成员变量将修改次数复制给预期修改次数一次
                it.remove();
            }
        }*/


        Map<String,String> map = new ConcurrentHashMap<>();
    }
}
