package com.xia.structe.day02;

import com.xia.structe.utils.SortTestHelper;

/**
 * 冒泡排序
 * 就是将最大的放到最后 和选择相反
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;//假设当前最大的值的位置在最后面
            for (int j = 0; j <= i; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            SortTestHelper.swap(arr, maxIndex, i);
        }
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, 1, 10);
        bubbleSort(array);
        SortTestHelper.printArray(array);
    }
}
