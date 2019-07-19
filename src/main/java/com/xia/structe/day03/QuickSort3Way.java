package com.xia.structe.day03;

import com.xia.structe.utils.SortTestHelper;

import java.util.Arrays;

/**
 * 三路快速排序
 */
public class QuickSort3Way {

    public static void quickSort3Way(int[] arr) {
        __quickSort3Way(arr, 0, arr.length - 1);
    }

    private static void __quickSort3Way(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //这里和之前有所不同 因为之前我们只需要返回一个=v的点 但是这里=v的是一个范围
        // 我们返回的是lt和gt的
        int[] p = __partition(arr, l, r);
        SortTestHelper.printArray(p);
        __quickSort3Way(arr, l, p[0]);
        __quickSort3Way(arr, p[1], r);
    }

    private static int[] __partition(int[] arr, int l, int r) {

        SortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        //观测值
        int v = arr[l];
        //满足 arr[l+1,lt]<v : arr[gt,r]>v
        int lt = l, gt = r + 1;
        int i = l + 1;
        //当两者碰上时 i和gt 说明已经排完了
        while (i < gt) {
            if (arr[i] < v) {
                //和lt+1进行交换
                SortTestHelper.swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i] > v) {
                //和gt-1进行交换
                SortTestHelper.swap(arr, i, gt - 1);
                gt--;
            } else { //arr[i]==v
                i++;
            }
        }
        //最后将 arr[l] 和arr[lt]进行交换
        SortTestHelper.swap(arr, l, lt);
        //这里lt-1的原因是 上面进行交换了 我并没有进行lt-1
        return new int[]{lt - 1, gt};
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, 1, 10);
        SortTestHelper.testSort("三路快速排序", QuickSort3Way.class, "quickSort3Way", array);
    }
}
