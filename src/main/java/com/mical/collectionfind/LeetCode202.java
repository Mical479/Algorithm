package com.mical.collectionfind;

import org.junit.Test;

import java.util.HashSet;

/**
 * 类 名 称：LeetCode202
 * 类 描 述：力扣网202题(349题、242题、350题）
 * 题 描 述：编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * 输 入: 19
 * 输 出: true
 * 解 释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 创建时间：2020/1/16 22:04
 * 创建人：Mical
 */
public class LeetCode202 {

    class Solution{
        public boolean isHappy(int n){
            HashSet<Integer> integers = new HashSet<>();

            int count = 0;

            while (count != 1){
                count = 0;
                while (n > 0) {
                    int temp = n % 10;
                    count = count + temp * temp;
                    n = n / 10;
                }
                //如果set中包含了 count，则会进入死循环不可能存在解
                if (integers.contains(count))
                    return false;

                integers.add(count);
                n = count;
            }
            return true;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
