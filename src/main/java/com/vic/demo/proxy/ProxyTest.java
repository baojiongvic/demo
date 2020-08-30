package com.vic.demo.proxy;

/**
 * 源程序名称：ProxyTest <br>
 * 软件著作权：恒生电子股份有限公司 版权所有 <br>
 * 系统名称：SEE2.0 <br>
 * 开发时间：2020/6/1 2:49 下午 <br>
 *
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
