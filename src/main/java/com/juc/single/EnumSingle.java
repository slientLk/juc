package com.juc.single;

import java.lang.reflect.Constructor;

/**
 * 枚举  其实本质也是也类
 */
public enum  EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return EnumSingle.INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        EnumSingle instance = EnumSingle.INSTANCE;

//        Exception in thread "main" java.lang.NoSuchMethodException: com.juc.single.EnumSingle.<init>()
        //idea和javap的反编译骗了我们
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle = declaredConstructor.newInstance();

        System.out.println(instance);
        System.out.println(enumSingle);
    }
}
