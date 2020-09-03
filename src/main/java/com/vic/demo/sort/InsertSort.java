package com.vic.demo.sort;

/**
 * @author baojiong20176<br>
 */
public class InsertSort {

    public static int[] insertSort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

}
