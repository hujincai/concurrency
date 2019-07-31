package com.mmall.concurrencyy.example.singleton;

import com.mmall.concurrencyy.annotation.NotRecommend;
import com.mmall.concurrencyy.annotation.ThreadSafe;

/**
 * 懒汉模式 -> 单例模式
 * 单例的实例在第一次使用的时候创建
 * Created by 胡金才
 * 2019/7/22 17:12
 */
@ThreadSafe
@NotRecommend // 性能开销 是我们不希望的所以synchronized不能保证性能
public class SingletonExample3 {
    // 私有构造函数
    private SingletonExample3() {

    }

    // 单例对象
    private static SingletonExample3 singletonExample1 = null;

    // 静态的工厂方法 可以保证synchronized
    public static synchronized SingletonExample3 getInstance() {
        if (singletonExample1 == null) {
            singletonExample1 = new SingletonExample3();
        }
        return singletonExample1;
    }
}
