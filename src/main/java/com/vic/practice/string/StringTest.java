package com.vic.practice.string;

/**
 * 源程序名称：StringTest <br>
 * 源程序包名：com.vic.practice.string <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/26 10:33 下午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        s2 = "hello";
        System.out.println(s1);
        System.out.println(s2);
    }
}
