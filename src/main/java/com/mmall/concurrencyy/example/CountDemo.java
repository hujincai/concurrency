package com.mmall.concurrencyy.example;

/**
 * Created by 胡金才
 * 2019/7/22 12:42
 */
public class CountDemo {

    public static void main(String[] args) {
        System.out.println(9996&9995);
        // 10011100001111
        //
        // 10011100001110
        // 10011100001101
        // 10011100001100 9996
        // 10011100001011 9995
    }
}
