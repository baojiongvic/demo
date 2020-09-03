package com.vic.demo.proxy;

/**
 * @author baojiong20176
 */
public class ProxyTest {

    public static void main(String[] args) {
        cglibProxy();
    }

    public static void cglibProxy() {
        CgLibProxyFactory cgLibProxyFactory = new CgLibProxyFactory();
        UserService userService = (UserService) cgLibProxyFactory.getProxy(UserServiceImpl.class);
        userService.save();
    }

    public static void jdkProxy() {
        ProxyFactory proxyFactory = new ProxyFactory();
        UserService userService = (UserService) proxyFactory.getProxy(UserServiceImpl.class);
        userService.save();
    }
}
