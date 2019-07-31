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
@ThreadSafe
public class AtomicExample6 {

    private static AtomicBoolean isHapped = new AtomicBoolean(false);

    /*请求总数 线程数*/
    public static int clientTotal = 5000;

    /*允许并发的线程数*/
    public static int threadTotal = 200;

    public static void main(String[] args) throws Exception {
        // 模拟并发执行
        // 首先定义一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 定义信号量 new Semaphore(threadTotal（允许同时执行的线程数）)
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 定义计数器 CountDownLatch new CountDownLatch(clientTotal（请求总数）);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                // 引入信号量，每次允许执行之前需要调用acquire()方法。
                // semaphore.acquire();该方法就是判断当前线程是否被执行，如果达到了一定的并发数后这个add可能临时被阻塞掉
                // 当semaphore.acquire()返回值以后下面的add方法才会被执行，执行完了以后需要通过semaphore.release()释放进程
                try {
                    semaphore.acquire();
                    test();
                    // 执行完后释放进程
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.error("InterruptedException",e);
                }
                // 调用countDown()。每执行完后计数器里的值都会进行减一操作
                countDownLatch.countDown();
            });
        }
        //在log之前加入await()方法就可以了,因为这个方法可以保证countDown()被减为0，而这个减为0的前提就是所有的线程都已经执行完。
        countDownLatch.await();
        // 通常我们这个线程池执行完以后 我们不在使用了这个时候我们可以关闭
        executorService.shutdown();
        // 如果我们希望在所有线程都执行完后打印值
        log.info("isHapped:{}",isHapped.get());
    }

    private static void test() {
        if (isHapped.compareAndSet(false,true)) {
            log.info("execute");
        }
        // 如果让指定代码只执行一次不重复。
    }
}
