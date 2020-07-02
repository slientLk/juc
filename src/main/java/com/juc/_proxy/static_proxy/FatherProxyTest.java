package com.juc._proxy.static_proxy;

import com.juc._proxy.pojo.Son;

public class FatherProxyTest {

    public static void main(String[] args) {
        Father f = new Father(new Son());
        f.findLove();
    }
}
