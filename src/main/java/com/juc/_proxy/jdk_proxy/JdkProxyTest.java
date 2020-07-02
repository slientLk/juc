package com.juc._proxy.jdk_proxy;

import com.juc._proxy.dao.Person;
import com.juc._proxy.pojo.Girl;

import java.lang.reflect.Proxy;

/**
 * java提供的代理实现，之所以要求我们必须提供一个接口，是因为它在生成代理类的时候已经继承了Proxy类，
 * 只能通过实现的方式来建立与我们需要代理的类的联系。
 */
public class JdkProxyTest {

    /**
     * Proxy.newProxyInstance(classLoader, interfaces, h)
     * 1、拿到被代理对象的引用，并且获取到它的所有的接口，反射获取。
     * 2、JDK Proxy 类重新生成一个新的类
     */
    public static void main(String[] args) {
        //这一句是生成代理类的class文件，不然会报找不到路径的io异常
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Girl girl = new Girl();
        //加载代理对象字节码,和被代理对象用一个类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //代理对象和被代理对象要具有相同的行为,实现相同接口
        Class<?>[] interfaces = girl.getClass().getInterfaces();
        //如何增强,如何代理
        MeiPoInvocationHandler h = new MeiPoInvocationHandler(girl);
        //生成代理对象
        Person p = (Person) Proxy.newProxyInstance(classLoader, interfaces, h);
        //通过代理类调用被代理类的方法
        p.findLove();
    }
}
