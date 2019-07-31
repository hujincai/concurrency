package com.mmall.concurrencyy.example.singleton;

import com.mmall.concurrencyy.annotation.ThreadSafe;

/**
 * 饿汉模式 -> 单例模式
 * 单例实例在类装载使用时进行创建
 * Created by 胡金才
 * 2019/7/22 17:12
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造函数
    private SingletonExample2() {

    }

    // 单例对象
    private static SingletonExample2 singletonExample1 = new SingletonExample2();

    // 静态的工厂方法
    public static SingletonExample2 getInstance() {
        return singletonExample1;
    }
}
