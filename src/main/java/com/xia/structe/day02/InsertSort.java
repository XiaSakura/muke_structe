package com.xia.structe.day02;

import com.xia.structe.utils.SortTestHelper;

import java.util.Arrays;

/**
 * 插入排序
 * 和扑克牌插入顺序类似
 */
public class InsertSort {

    /**
     * 只将arr中的[l,r]进行插入排序
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void insertSort(int[] arr, int l, int r) {
        for (int i = l; i < r; i++) {
            int tmp = arr[i]; //存放当前需要比较数
            int j;
            for (j = i; j > l && arr[j] < arr[j - 1]; j--) {
                arr[j - 1] = arr[j];
            }
            arr[j] = tmp;
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//存放当前需要比较数
            int j;//我们需要知道最后一次j所在的位置 temp所插入的位置
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                //前一个数和当前数做比较 如果小的情况 就交换
                //使用swap比较浪费时间 所以我们需要直接变换
                //SortTestHelper.swap(arr, j - 1, j);
                arr[j] = arr[j - 1];
            }
            //已经找到当前循环中 temp最适合存放的位置
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, 1, 10);
        int[] array2 = array.clone();
//        SortTestHelper.testSort("插入排序", InsertSort.class, "insertSort", array);
//        SortTestHelper.testSort("选择排序", SelectSort.class, "selectionSort", array2);
        insertSort(array, 1, 9);
        SortTestHelper.printArray(array);
    }
}
