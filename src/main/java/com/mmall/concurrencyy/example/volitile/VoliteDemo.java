package com.mmall.concurrencyy.example.volitile;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by 胡金才
 * 2019/7/9 15:24
 */
@Slf4j
public class VoliteDemo {

    private int number = 0;

    public void increase() {
        number ++;
    }

    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {
        final VoliteDemo voliteDemo = new VoliteDemo();
        blMethod(voliteDemo);

        //线程未执行完，主线程让出CPU资源
        while(Thread.activeCount() > 0) {
            Thread.yield();
        }

        System.out.println("ssss" + voliteDemo.getNumber());
    }

    private static void blMethod(VoliteDemo voliteDemo) {
        for (int i = 0; i <=999 ; i++) {
            new Thread(() -> {
                voliteDemo.increase();
            }).start();
        }
    }


}
