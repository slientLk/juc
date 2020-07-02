package com.juc.single;

//静态内部类
public class Holder {

    private Holder() {
    }

    public static class InnerClass{
        private static final Holder holder = new Holder();
    }

    public static Holder getInstance(){
        return InnerClass.holder;
    }
}
