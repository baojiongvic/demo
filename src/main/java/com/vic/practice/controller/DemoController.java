package com.vic.practice.controller;

import com.vic.practice.service.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class DemoController {

    @Autowired
    private TestInterface testInterface;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo() {
        return "success";
    }

    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public String print() {
        testInterface.print();
        return "success";
    }
}
