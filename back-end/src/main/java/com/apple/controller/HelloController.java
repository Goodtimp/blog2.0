package com.apple.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @RequestMapping(value = "/", produces = "application/json;charset=UTF-8", method = RequestMethod.PUT)
    @ResponseBody
    public String hello() {
        return "你好,百度！";
    }
}