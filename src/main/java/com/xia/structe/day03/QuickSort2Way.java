package com.xia.structe.day03;

import com.xia.structe.utils.SortTestHelper;

/**
 * 双路快速排序
 */
public class QuickSort2Way {

    public static void quickSort(int[] arr) {
        __quickSort(arr, 0, arr.length - 1);
    }

    private static void __quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //为了保证 arr[l,p-1]<=arr[p]  arr[p+1,r]>=arr[p]
        int p = __partition(arr, l, r);
        __quickSort(arr, l, p - 1);
        __quickSort(arr, p + 1, r);
    }

    private static int __partition(int[] arr, int l, int r) {
        //得到观测值
        int v = arr[l];
        //左边开始点i 右边开始点j
        int i = l + 1, j = r;
        while (i >= j) {
            while (i <= r && arr[i] < v) {
                i++;
            }
            while (j >= l + 1 && arr[j] > v) {
                j--;
            }
            SortTestHelper.swap(arr, i, j);
        }
        SortTestHelper.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 1, 10);
        SortTestHelper.testSort("双路快速排序", QuickSort.class, "quickSort", array);
    }
}
