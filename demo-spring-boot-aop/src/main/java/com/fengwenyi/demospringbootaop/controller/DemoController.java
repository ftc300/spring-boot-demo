package com.fengwenyi.demospringbootaop.controller;

import com.fengwenyi.demospringbootaop.annotation.LogExecutionTime;
import com.fengwenyi.demospringbootaop.annotation.QueryData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2020/9/12
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
//    @LogExecutionTime()
    @QueryData(key = "#id", cacheName = "USER", needLog = true)
    public String hello(String id) {
        return "Hello";
    }

}
