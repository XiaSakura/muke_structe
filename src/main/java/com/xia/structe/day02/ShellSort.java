package com.xia.structe.day02;


import com.xia.structe.utils.SortTestHelper;

/**
 * 希尔排序
 */
public class ShellSort {


    public static void shellSort(int[] arr) {
        int increment = arr.length;
        do {
            increment = increment / 3 + 1;//初始化间隔
            for (int i = increment; i < arr.length; i++) {
                //对每一个小序列执行直接插入排序
                int tmp = arr[i];
                int j;
                for (j = i; j > 0 && arr[j] < arr[j - increment]; j = j - increment) {
                    arr[j - increment] = arr[j];
                }
                arr[j] = tmp;
            }
        } while (increment > 1);
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, 1, 10);
        SortTestHelper.testSort("希尔排序", ShellSort.class, "shellSort", array);
    }
}
