package com.mmall.concurrencyy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 胡金才
 * 2019/7/5 13:40
 */
@Controller
@Slf4j
public class TestControlller {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }
}
