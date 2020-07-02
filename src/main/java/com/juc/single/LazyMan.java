package com.juc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * DCL 懒汉式
 */
public class LazyMan {

    private volatile static LazyMan lazyMan;

    private static boolean flag = false;

    public LazyMan() {
        synchronized (LazyMan.class){
            if (flag == false){
                flag = true;
            }else {
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    public static LazyMan getInstance() {
        if (lazyMan == null){
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws Exception {
       /* for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                getInstance();
            }).start();
        }*/
//        LazyMan instance =LazyMan.getInstance();
        Class<LazyMan> clazz = LazyMan.class;

        Field field = clazz.getDeclaredField("flag");
        field.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = clazz.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);

        LazyMan lazyMan1 = declaredConstructor.newInstance();

        field.set(lazyMan1,true);

        LazyMan lazyMan2 = declaredConstructor.newInstance();

        System.out.println(lazyMan1);
        System.out.println(lazyMan2);

    }
}
