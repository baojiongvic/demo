package com.vic.practice.jvm.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author baojiongvic
 **/
public class OomTest {

    public static void main(String[] args) {
        List<Picture> list = new ArrayList<>();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            list.add(new Picture(new Random().nextInt(1024 * 1024)));
        }
    }
}

class Picture {
    private byte[] pixels;

    public Picture(int length) {
        pixels = new byte[length];
    }
}