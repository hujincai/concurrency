package com.mmall.concurrencyy.example.singleton;

import com.mmall.concurrencyy.annotation.NotRecommend;
import com.mmall.concurrencyy.annotation.NotThreadSafe;
import com.mmall.concurrencyy.annotation.ThreadSafe;

/**
 * 懒汉模式 -> 双重同步锁单例模式
 * 单例的实例在第一次使用的时候创建
 * Created by 胡金才
 * 2019/7/22 17:12
 */
@ThreadSafe
public class SingletonExample4 {
    // 私有构造函数
    private SingletonExample4() {

    }

    // 单例对象 volatile + 双重检测机制 -> 禁止指令重排
    private volatile static SingletonExample4 instance = null;

    // 1.memory = allocate() 分配对象内存空间
    // 2.ctorInstance() 初始化对象
    // 3.instance = memory 设置instance指向刚分配的内存

    // 静态的工厂方法 可以保证synchronized
    public static SingletonExample4 getInstance() {
        if (instance == null) { // 双重检测机制  B
            synchronized (SingletonExample4.class) { // 同步锁
                if (instance == null) {
                    instance = new SingletonExample4(); // A - 3
                }
            }
        }
        return instance;
    }
}
