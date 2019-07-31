package com.mmall.concurrencyy.example.atomic;

import com.mmall.concurrencyy.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 胡金才
 * 2019/7/9 15:24
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    /**
     * AtomicIntegerFieldUpdater原子性是去更新某一个类的实例 在这里就表示的是我们的AtomicExample5
     * AtomicIntegerFieldUpdater 核心作用是要更新指定的一个类的某一个字段的值。
     * 某一个字段必须是通过特殊关键字volatile修饰的，同时不能是static修饰的才可以。（要求）
     */
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {

        AtomicExample5 example5 = new AtomicExample5();

        if (updater.compareAndSet(example5,100,120)) {
            log.info("update success, 1 {}",example5.getCount());
        }

        if (updater.compareAndSet(example5,100,120)) {
            log.info("update success, 2 {}",example5.getCount());
        } else {
            log.info("update failed, {}",example5.getCount());
        }
    }
}
