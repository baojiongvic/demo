package com.vic.practice.spi;

/**
 * 源程序名称：GoSpi <br>
 * 源程序包名：com.vic.demo.spi <br>
 * 系统名称：demo <br>
 * 开发时间：2020/9/9 8:49 下午 <br>
 *
 * @Author baojiong20176 <br>
 * <br>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 */
public class GoSpi implements Spi {
    @Override
    public void doSomething() {
        System.out.println("Go Spi");
    }
}
