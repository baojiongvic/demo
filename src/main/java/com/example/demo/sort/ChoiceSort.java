package com.example.demo.sort;

/**
 * @author baojiong20176<br>
 * @copyright 恒生电子股份有限公司 版权所有<br>
 * @date 2019/6/12 17:10
 * @description
 */
public class ChoiceSort {

    public static int[] choiceSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

}
