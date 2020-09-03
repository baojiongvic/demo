package com.vic.demo.sort;

/**
 * @author baojiong20176<br>
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
