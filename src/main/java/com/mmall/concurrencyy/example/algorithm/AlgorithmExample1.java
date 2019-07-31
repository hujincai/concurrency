package com.mmall.concurrencyy.example.algorithm;

import java.util.Arrays;

/**
 * Created by 胡金才
 * 2019/7/23 14:32
 */
public class AlgorithmExample1 {

    static String s = "rat";
    static String t = "cat";
    // 两个长度都为26的字符数组
    public static void main(String[] args) {
        System.out.println(testMethod(s,t));
    }

    public static boolean testMethod(String s,String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();

        if (chars.length!=chars1.length) {
            System.out.println("两个字符串长度不相等!!");
            return false;
        }
        Arrays.sort(chars);
        Arrays.sort(chars1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!=chars1[i]) {
                return false;
            }
        }
        return true;
    }
}
