package com.mmall.concurrencyy.example.publish;

import com.mmall.concurrencyy.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by 胡金才
 * 2019/7/22 16:44
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String [] states = {"a","b","c"};

    public String [] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}",Arrays.toString(unsafePublish.getStates()));
    }
}
