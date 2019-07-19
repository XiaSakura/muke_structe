package com.xia.structe.day03;

import com.xia.structe.day02.InsertSort;
import com.xia.structe.utils.SortTestHelper;

/**
 * 普通的快速排序
 */
public class QuickSort {

    /**
     * 普通的快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        __quickSort(arr, 0, arr.length - 1);
    }

    private static void __quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
//        if (r - l <= 15) {
//            InsertSort.insertSort(arr, l, r);
//            return;
//        }
        //先partition 找到p 使得 arr[l,p-1]<arr[p] ; arr[p+1,p]>arr[p]
        int p = __partition(arr, l, r);
        __quickSort(arr, l, p - 1);
        __quickSort(arr, p + 1, r);

    }

    private static int __partition(int[] arr, int l, int r) {

        SortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        //初始化定义
        int v = arr[l]; //当前数组的第一位为基点
        //arr[l+1,j]<v arr[j+1,i)>v
        int j = l;
        //i是我们要考察的元素
        for (int i = l + 1; i <= r; i++) {
            //存放到<v里面
            if (arr[i] < v) {
                SortTestHelper.swap(arr, i, j + 1);
                j++;
            }
        }
        //最后需要将考察的元素 和j进行交换
        SortTestHelper.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10000, 1, 10);
        SortTestHelper.testSort("普通快速排序", QuickSort.class, "quickSort", array);

    }
}
