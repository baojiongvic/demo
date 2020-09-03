package com.vic.demo.service;

import org.springframework.stereotype.Service;

/**
 * @author baojiong20176
 */
@Service
public class TestInterfaceImpl implements TestInterface {
    @Override
    public void printf() {
        System.out.println("test");
    }
}
