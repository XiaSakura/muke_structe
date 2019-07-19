package com.xia.structe.day02;

import com.xia.structe.utils.SortTestHelper;

public class SelectSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex=i;//当前最小的值 假设第i
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex=j;//当前最小值的位置
                }
            }
            //当前循环中找到最小的值放到 当前最前面
            SortTestHelper.swap(arr,minIndex,i);
        }
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10000, 1, 10);
        //selectionSort(array);
        SortTestHelper.testSort("选择排序",SelectSort.class,"selectionSort",array);
    }
}
