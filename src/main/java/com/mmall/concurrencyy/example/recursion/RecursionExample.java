package com.mmall.concurrencyy.example.recursion;

/**
 * Created by 胡金才
 * 2019/7/30 13:31
 */
public class RecursionExample {

    // for循环实现斐波那契（兔子数列）
    public static long testMethod(long index) {
        // 斐波那契数列 1,1,2,3,5,8,13,21,34,55
        // a,b,c,b
        long a = 1;
        long b = 1;
        long c = 0;
        if (index==1||index==0) {
            return 1;
        }
        if (index >= 2) {
            for (int i = 2; i <=index; i++) {
                c = a + b;
                a = b;// a和b交换位置
                b = c; // b和c交换位置
            }
        }
        return c;
    }

    public static void main(String[] args) {
        // 前十位斐波那契
        for (int i = 1; i <=10; i++) {
            long num = testMethod2(i);
            System.out.println(num);
        }
    }

    // 递归实现斐波那契 根据位数找出对应的数
    public static long testMethod2(long index) {
        if (index==1||index == 2) {
            return 1;
        }
        return testMethod2(index-1) + testMethod2(index-2);
    }
}
