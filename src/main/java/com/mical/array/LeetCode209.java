package com.mical.array;

/**
 * 类 名 称：LeetCode209
 * 类 描 述：力扣网209题(3题、438题、76题）
 * 题 描 述：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 输 入: s = 7, nums = [2,3,1,2,4,3]
 * 输 出: 2
 * 解 释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 创建时间：2020/1/14 20:32
 * 创建人：Mical
 */
public class LeetCode209 {
    class Solution {
        /**
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         * 使用了滑动窗口的概念
         * @param s
         * @param nums
         * @return
         */
        public int minSubArrayLen(int s, int[] nums) {
            int l = 0, r = -1; //定义滑动窗口的左边界和右边界，初始化时窗口不包含任何元素,nums[l...r]为我们的滑动窗口
            int sum = 0; //定义求和
            int length = nums.length + 1; //定义子数组的长度，初始化为取不到的值
            while (l < nums.length){
                if (sum < s && r + 1 < nums.length){ //如果子窗口的值比结果小，将右指针向右滑动；同时要保证右指针的边界，之所以为r+1小于length，是因为之后进行了 r++。
                    r++;
                    sum += nums[r];
                }else { //如果子窗口的值比结果大，将左指针向右滑动，这里应该先跟新sum的值，再加加，不认加加了就没法更新值了
                    sum -= nums[l];
                    l ++;
                }
                if (sum >= s){ //判断如果子窗口的结果大于 s ，就将length赋值给较小的
                    length = Math.min(r - l + 1, length);
                }
            }

            if (length == nums.length + 1)
                return 0;

            return length;
        }
    }
}
