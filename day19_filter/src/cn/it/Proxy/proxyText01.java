package cn.it.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyText01 {
    public static void main(String[] args) {
        lenovo lenovo = new lenovo();

        Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                return null;
            }
        });


        String sale = lenovo.sale(5555);
        System.out.println(sale);

    }
}
