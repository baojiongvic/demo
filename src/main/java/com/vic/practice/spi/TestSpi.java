package com.vic.practice.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 源程序名称：TestSpi <br>
 * 源程序包名：com.vic.demo.spi <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/9 8:50 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 */
public class TestSpi {

    public static void main(String[] args) {
        ServiceLoader<Spi> serviceLoader = ServiceLoader.load(Spi.class);
        Iterator<Spi> iterator = serviceLoader.iterator();
        while(iterator.hasNext()) {
            iterator.next().doSomething();
        }
    }
}
