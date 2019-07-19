package com.xia.structe.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SortTestHelper {

    /**
     * 生成具有n个长度的数组 其每个元素范围为[l,R]
     *
     * @param n 数组长度
     * @param L 左边
     * @param R 右边
     * @return 创建的数组
     */
    public static int[] generateRandomArray(int n, int L, int R) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (L + Math.random() * (R - L + 1));
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static <T> void testSort(String sortName, Class<T> clazz, String methodName, int[] arr) {
        try {
            T instance = clazz.newInstance();
            Method method = clazz.getMethod(methodName, int[].class);
            long startTime = System.nanoTime();
            method.invoke(clazz, arr);
            long endTime = System.nanoTime();
            long time = endTime-startTime;
            System.out.println(sortName + "算法花费了" + time/1000 + "ms");
            printArray(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
