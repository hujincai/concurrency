package com.mmall.concurrencyy.example.singleton;

import com.mmall.concurrencyy.annotation.Recommend;
import com.mmall.concurrencyy.annotation.ThreadSafe;

/**
 * 饿汉模式 -> 枚举定义模式 最安全
 * Created by 胡金才
 * 2019/7/22 17:12
 */
@ThreadSafe
@Recommend
public class SingletonExample6 {

    // 私有构造函数
    private SingletonExample6() {

    }

    public static SingletonExample6 getInstance() {
        return Singleton.INSTANCE.getInstace();
    }
    private enum Singleton {
        INSTANCE;

        private SingletonExample6 sinleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            sinleton = new SingletonExample6();
        }

        public SingletonExample6 getInstace() {
            return sinleton;
        }
    }
}
