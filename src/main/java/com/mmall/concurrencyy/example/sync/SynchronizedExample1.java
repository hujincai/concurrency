package com.mmall.concurrencyy.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 胡金才
 * 2019/7/16 11:44
 */
@Slf4j
public class SynchronizedExample1 {

    // 修饰一个代码块
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("tset1 {} - {}", j, i);
            }
        }
    }

    // 修饰一个方法（被修饰的方法称为同步方法）
    public synchronized void test2 () {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}",i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example12 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example12.test1(2);
        });
    }
}
