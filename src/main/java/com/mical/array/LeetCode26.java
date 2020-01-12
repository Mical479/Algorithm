package com.mical.array;

import org.junit.Test;

/**
 * 类 名 称：LeetCode26
 * 类 描 述：力扣网26题(27、283)为同类型的题
 * 题 描 述：给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 创建时间：2020/1/12 17:10
 * 创建人：Mical
 */
public class LeetCode26 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > nums[k]){
                    nums[++k] = nums[i];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
            return k;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int i = solution.removeDuplicates(new int[]{ 1, 1, 2});
        System.out.println("结果： " + i);
    }
}
