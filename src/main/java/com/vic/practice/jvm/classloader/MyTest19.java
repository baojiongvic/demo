package com.vic.practice.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * 源程序名称：MyTest19 <br>
 * 源程序包名：com.vic.practice.jvm.classloader <br>
 * 系统名称：practice <br>
 * 软件著作权：恒生电子股份有限公司 版权所有 <br>
 * 开发时间：2020/10/4 4:03 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */
public class MyTest19 {

    // java -Djava.ext.dirs=./ com.vic.practice.jvm.classloader.MyTest19

    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
