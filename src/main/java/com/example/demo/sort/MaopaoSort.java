package com.example.demo.sort;

/**
 * @author baojiong20176<br>
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @date 2019/6/12 14:31
 * @description
 */
public class MaopaoSort {

    public static int[] sort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            for (int j = 0; j < ints.length - i ; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        return ints;
    }

}
