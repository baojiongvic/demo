package com.vic.practice.service.impl;

import com.vic.practice.service.TestInterface;
import org.springframework.stereotype.Service;

/**
 * @author baojiong20176
 */
@Service
public class TestInterfaceImpl implements TestInterface {
    @Override
    public void print() {
        System.out.println("test");
    }
}
