package com.xia.structe.day03;

import com.xia.structe.utils.SortTestHelper;

/**
 * 自底向上的归并排序
 * 就是我们不需要递归(拆分) 只需要迭代就可以实现归并了
 */
public class MergeSortBU {

    public static void mergeSortBu(int[] arr) {
        //首先定义size 分次分割的元素个数
        for (int size = 1; size <= arr.length; size += size) {
            //首先两个元素一个小段 两两之间进行归并排序的过程
            //i是为了区分 每一段的开始位置
            for (int i = 0; i+size < arr.length; i += size + size) {
                __merge(arr, i, i + size - 1, Math.min(i + size + size - 1,arr.length-1));
            }
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
        int[] array = SortTestHelper.generateRandomArray(100, 1, 10);
        SortTestHelper.testSort("自底向上的归并排序", MergeSortBU.class, "mergeSortBu", array);
    }
}
