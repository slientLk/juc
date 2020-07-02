package com.juc._proxy.static_proxy;

import com.juc._proxy.dao.Person;
import com.juc._proxy.pojo.Son;

/**
 * 静态代理对象
 */
public class Father implements Person {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    @Override
    public void findLove() {
        System.out.println("父亲物色对象");
        son.findLove();
        System.out.println("双方父母同意，确立关系" +
                "");
    }
}
