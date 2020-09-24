package com.vic.practice.valuetransfer;

/**
 * 源程序名称：ValueTransferTest1 <br>
 * 源程序包名：com.vic.practice.valuetransfer <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/25 12:17 上午 <br>
 * 功能描述：
 *
 * @author baojiong20176 <br>
 * <br>
 * <p>
 * 值传递
 * 1、基本数据类型传递的为真是存储的数据值
 * 2、引用数据类型传递的为存储数据的地址值
 */
public class ValueTransferTest1 {

    public static void main(String[] args) {
        int m = 10;
        int n = 20;

        swap(m, n);
        System.out.println("m=" + m + ", n=" + n);

        Data data = new Data();
        data.m = 10;
        data.n = 20;

        objectSwap(data);

        System.out.println("m=" + data.m + ", n=" + data.n);
    }

    static void swap(int m, int n) {
        int temp = n;
        n = m;
        m = temp;
        System.out.println("swap m=" + m + ", n=" + n);
    }

    static void objectSwap(Data data) {
        int temp = data.n;
        data.n = data.m;
        data.m = temp;
    }
}

class Data {
    int m;
    int n;
}
