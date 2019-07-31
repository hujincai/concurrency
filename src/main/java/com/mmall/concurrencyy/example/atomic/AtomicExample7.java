package com.mmall.concurrencyy.example.atomic;

import com.mmall.concurrencyy.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by 胡金才
 * 2019/7/9 15:24
 */
@Slf4j
public class AtomicExample7 {

    private static volatile AtomicExample7 instance = null;

    private AtomicExample7() {};

    public static AtomicExample7 getInstance() {
        if (instance == null) {
            instance = new AtomicExample7();
            System.out.println("---initonce");
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
