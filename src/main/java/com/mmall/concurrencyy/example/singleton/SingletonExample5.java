package com.mmall.concurrencyy.example.singleton;

import com.mmall.concurrencyy.annotation.ThreadSafe;

/**
 * 饿汉模式 -> 单例模式
 * 单例实例在类装载使用时进行创建
 * Created by 胡金才
 * 2019/7/22 17:12
 */
@ThreadSafe
public class SingletonExample5 {

    // 私有构造函数
    private SingletonExample5() {

    }
    // 单例对象
    private static SingletonExample5 instance = null;

    static {
        instance = new SingletonExample5();
    }

    // 静态的工厂方法
    public static SingletonExample5 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
