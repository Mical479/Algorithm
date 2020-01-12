package com.mical.array;

import org.junit.Test;

import java.util.Random;

/**
 * 类 名 称：BinarySearch
 * 类 描 述：二分查找
 * 创建时间：2020/1/12 15:05
 * 创建人：Mical
 */
public class BinarySearch {

    /**
     * 二分查找算法
     *
     * @param arr    传入数组
     * @param n      数组的大小
     * @param target 待查找元素
     * @return 如果查找到元素，返回该元素，没有则返回-1
     */
    public static int binarySearch(int[] arr, int n, int target) {
        int l = 0, r = n - 1; //在[l...r]的范围里寻找target
        while (l <= r) { // 当 l==r 时，区间[l...r]依然是有效的
            int mid = (l + r) / 2; //此处有可能产生整型溢出，应该用：mid = l + (r - 1) / 2;
            if (arr[mid] == target)
                return mid;
            if (target > arr[mid])
                l = mid + 1; //target在[mid+1...r]中
            else
                r = mid - 1; //target 在[l...mid-1]中
        }
        return -1;
    }

    /**
     * 对函数进行测试
     */
    @Test
    public void test() {

        int n = 1000000;

        //生成一个数组
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            assert i == BinarySearch.binarySearch(arr, arr.length, i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("所用时间：" + (endTime - startTime) + "毫秒");
    }
}
