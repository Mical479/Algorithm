package com.mical.array;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.InvalidObjectException;
import java.util.Arrays;

/**
 * 类 名 称：LeetCode167
 * 类 描 述：力扣网167题（125题、345题、11题）
 * 题 描 述：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 输 入: numbers = [2, 7, 11, 15], target = 9
 * 输 出: [1,2]
 * 创建时间：2020/1/13 20:18
 * 创建人：Mical
 */
public class LeetCode167 {

    class Solution {

        /**
         * 对撞指针，首先判断数组第一位和最后一位相加是否等于结果
         * 如果相加之后的结果大于 target，那么最后一位就应该像前移动，再重复动作
         * 如果相加之后的结果小于 target，那么第一位就应该向后移动，再重复动作
         * @param numbers
         * @param target
         * @return
         * @throws InvalidArgumentException
         */
        public int[] twoSum(int[] numbers, int target) throws InvalidArgumentException {
            int[] arr;
            int l = 0, r = numbers.length - 1;
            while (l < r) {
                if (numbers[l] + numbers[r] == target) {
                    arr = new int[]{l + 1, r + 1};
                    return arr;
                } else if (numbers[l] + numbers[r] < target)
                    l++;
                else
                    r--;
            }
            throw new InvalidArgumentException(new String[]{"The input has no solution"});
        }

        /**
         * 使用二分查找法，使用 i 遍历数组，每获取一个 i 的值，在 [i+1...numbers.length-1] 里面查找 target - numbers[i] 的值
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum1(int[] numbers, int target){
           int i = 0;
           while (i < numbers.length){
               int k = target - numbers[i];
               int b = Arrays.binarySearch(numbers, i + 1, numbers.length - 1, k);
               if (b > 0)
                   return new int[]{numbers[i], b};
           }
           return null;
        }
    }
}
