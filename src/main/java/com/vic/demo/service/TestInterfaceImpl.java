package com.vic.demo.service;

import org.springframework.stereotype.Service;

/**
 * 源程序名称： <br>
 * 软件著作权：恒生电子股份有限公司 版权所有 <br>
 * 系统名称：<br>
 * 开发时间：2020/6/6 1:49 下午 <br>
 *
 * @author baojiong20176
 */
@Service
public class TestInterfaceImpl implements TestInterface {
    @Override
    public void printf() {
        System.out.println("test");
    }
}