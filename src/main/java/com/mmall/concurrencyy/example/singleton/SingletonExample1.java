package com.mmall.concurrencyy.example.singleton;

import com.mmall.concurrencyy.annotation.NotThreadSafe;

/**
 * 懒汉模式 -> 单例模式
 * 单例的实例在第一次使用的时候创建
 * 多线程情况下同时访问getInstance 可能会被调用两次构造函数
 * Created by 胡金才
 * 2019/7/22 17:12
 */
@NotThreadSafe
public class SingletonExample1 {
    // 私有构造函数
    private SingletonExample1() {

    }

    // 单例对象
    private static SingletonExample1 singletonExample1 = null;

    // 静态的工厂方法
    public static SingletonExample1 getInstance() {
        if (singletonExample1 == null) {
            singletonExample1 = new SingletonExample1();
        }
        return singletonExample1;
    }
}
