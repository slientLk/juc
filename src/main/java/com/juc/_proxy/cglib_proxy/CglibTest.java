package com.juc._proxy.cglib_proxy;

import com.juc._proxy.pojo.Customer;
import net.sf.cglib.core.DebuggingClassWriter;

public class CglibTest {
    /**
     * /JDK是采用读取接口的信息
     * CGLib覆盖父类方法
     * 目的：都是生成一个新的类，去实现增强代码逻辑的功能
     *
     * JDK Proxy 对于用户而言，必须要有一个接口实现，目标类相对来说复杂
     * CGLib 可以代理任意一个普通的类，没有任何要求
     *
     * CGLib 生成代理逻辑更复杂，效率,调用效率更高，生成一个包含了所有的逻辑的FastClass，不再需要反射调用
     * JDK Proxy生成代理的逻辑简单，执行效率相对要低，每次都要反射动态调用
     *
     * CGLib 有个坑，CGLib不能代理final的方法
     * @param args
     */
    public static void main(String[] args) {
        //生成的字节码，其中一个是代理类，其他2个是FastClass类，一个是代理类的FastClass，一个是被代理类的FastClass机制。
        //FastClass机制就是对一个类的方法建立索引，调用方法时根据方法的签名来计算索引，通过索引来直接调用相应的方法。
        try {
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"C:\\Users\\coderK\\Desktop");
            Customer customer = (Customer) new MeiPoCglib().getInstance(Customer.class);
            customer.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
