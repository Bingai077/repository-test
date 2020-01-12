package com.bingai.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**模拟一个消费者
 * @author bingai
 * @create 2019-12-21 18:40
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        //producer.saleProduct(10000.0);
        /*
            动态代理：
                特点：字节码谁用谁创建，谁用谁加载
                作用：不修改源码的基础上对方法增强
                分类：
                    基于接口的动态代理
                    基于子类的动态代理
                基于接口的动态代理：
                    涉及的类：Proxy
                    提供者：JDK官方

                如何创建代理对象：
                    使用Proxy类中的newProxyInstance方法
                创建代理对象的要求：
                    被代理类至少实现一个接口，如果没有则不能使用
                newProxyInstance方法的参数：
                    ClassLoader:类加载器
                        用于加载代理对象字节码的。和【被代理对象】使用相同的类加载器【固定写法】
                    Class[]：字节码数组
                        用于让代理对象和被带理对象有相同的方法【固定写法】
                    InvocationHandler
                        用于提供增强的代码
                        让我们写如何代理，一般情况下都是写一个接口的实现类，通常情况下都是【匿名内部类】，但不是必须的
                        此接口的实现类都是谁用谁写

         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * 方法参数的含义
                     * @param proxy   代理对象的引用
                     * @param method  当前执行的方法
                     * @param args    当前执行方法所需的参数
                     * @return        和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;
                        //1.获取方法执行的参数
                        Double money = (Double) args[0];
                        //2.判断当前方法是不是销售
                        if("saleProduct".equals(method.getName())){
                            returnValue = method.invoke(producer,money * 0.8);
                        }
                        return returnValue;

                    }
                }
        );

        proxyProducer.saleProduct(10000.0);


    }
}
