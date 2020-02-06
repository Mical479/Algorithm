package com.mical.collectionfind;

import java.util.HashSet;

/**
 * 类 名 称：LeetCode219(220题）
 * 类 描 述：给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 输 入：nums = [1, 2, 3, 1], k = 3
 * 输 出：true
 * 创建时间：2020/2/6 11:34
 * 创建人：Mical
 */
public class LeetCode219 {

    class Solution {
        /**
         * 使用滑动窗口，题目是说数组中两个相同的元素的索引之差最大为k，可转化为在 [l, l + k] 区间内判断是否存在两个相同的数
         * 同时通过 set 集合的大小来判断窗口的大小
         * 时间复杂度：O(n)
         * 空间复杂度：O(k)
         * @return
         */
        public boolean containsNearbyDuplicate(int[] nums, int k){

            HashSet<Integer> integers = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if ( integers.contains(nums[i]) )
                    return true;
                integers.add(nums[i]);

                //保持set中最多有k个元素
                if (integers.size() == k + 1)
                    integers.remove(nums[i - k]);
            }
            return false;
        }
    }
}
