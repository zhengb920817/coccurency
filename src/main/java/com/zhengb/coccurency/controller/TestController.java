package com.zhengb.coccurency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengb on 2018-03-18.
 */
@Slf4j
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){

        log.info("request is comming");
        return  "test";
    }
}
