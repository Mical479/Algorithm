package com.mical.collectionfind;

import org.junit.Test;

import java.util.HashMap;

/**
 * 类 名 称：LeetCode1
 * 类 描 述：力扣网1题（15题，18题，16题）
 * 题 描 述：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 输 入：nums = [2, 7, 11, 15], target = 9
 * 输 出：[0, 1]
 * 创建时间：2020/1/24 9:41
 * 创建人：Mical
 */
public class LeetCode1 {
    class Solution{
        //使用Map的数据结构，key 记录数值，value 记录索引,
        // 由于数组中可能存在多个一样的值，所以不能先一次性将所有的元素全部放入map中去
        //需要一边遍历一边去查找
        public int[] twoSum(int[] nums, int target){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int[] ta = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (hashMap.get(temp) != null){
                    ta[0] = hashMap.get(temp);
                    ta[1] = i;
                    return ta;
                }else{
                    hashMap.put(nums[i], i);
                }
            }

            throw new IllegalArgumentException();
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.twoSum(new int[]{3, 2, 4}, 6);
    }
}
