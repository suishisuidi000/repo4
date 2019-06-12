package cn.it.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理类
public class proxyText {
    public static void main(String[] args) {
        //创建真实对象
        lenovo lenovo = new lenovo();

        Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                return null;
            }
        });

        String sale = lenovo.sale(3000.0);
        System.out.println(sale);


    }
}
