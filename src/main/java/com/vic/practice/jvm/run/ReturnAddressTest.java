package com.vic.practice.jvm.run;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author baojiong20176
 * @create 2021/3/9 6:50 上午
 */
public class ReturnAddressTest {

    public void method2() {
        try {
            method1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method1() throws IOException {
        FileReader file = new FileReader("test.txt");
        char[] buffer = new char[1024];
        int len;
        while ((len = file.read(buffer)) != -1) {
            String str = new String(buffer);
            System.out.println(str);
        }
        file.close();
    }
}
