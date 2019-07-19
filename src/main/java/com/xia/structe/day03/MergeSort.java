package com.xia.structe.day03;

import com.xia.structe.day02.InsertSort;
import com.xia.structe.utils.SortTestHelper;

/**
 * 归并排序
 * 先拆分 再进行归并  逐层向上升
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        __mergerSort(arr, 0, arr.length - 1);
    }

    //递归调用归并排序,对arr[l..r]进行排序
    private static void __mergerSort(int[] arr, int l, int r) {
        if (l >= r) {
            //中止条件
            return;
        }
        //以使用插入排序 来提高性能 因为当数据已经很小的时候 数据都是近乎有序的
        if (r - l <= 15) {
            InsertSort.insertSort(arr, l, r);
        }
        //mid是放到了第一个数组 的最后一个位置 为了方便区分当前数组 前一个数组的最后一个位置
        int mid = (r + l) / 2;
        __mergerSort(arr, l, mid); //划分相对左边的部分
        __mergerSort(arr, mid + 1, r);//划分相对右边的部分

        //真正需要排序的情况 因为<mid 必然小于arr[mid]
        if (arr[mid] > arr[mid + 1]) {
            //当上面两个递归调用完成时 进行归并
            __merge(arr, l, mid, r);
        }
    }

    //将arr[l..mid]和arr[mid+1...r]进行归并 利用aux辅助空间
    private static void __merge(int[] arr, int l, int mid, int r) {
        //因为aux是从0开始 但是我们这里从l开始 有偏移量  aux是辅助空间
        int[] aux = new int[r - l + 1];
        //给aux赋值
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        //定义 当前左部分i 和右部分j
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            //i>mid和j>r
            //是为了防止数组越界
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] >= aux[j - l]) {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10000, 1, 1000);
        int[] array2 = array.clone();
        SortTestHelper.testSort("归并排序", MergeSort.class, "mergeSort", array);
        SortTestHelper.testSort("插入排序", InsertSort.class, "insertSort", array2);
    }
}
