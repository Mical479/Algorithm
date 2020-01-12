package com.mical.array;

import org.junit.Test;

/**
 * 类 名 称：LeetCode27
 * 类 描 述：力扣网27题
 * 题 描 述：给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 创建时间：2020/1/12 16:51
 * 创建人：Mical
 */
public class LeetCode27 {

    class Solution{
        public int removeElement(int[] nums, int val){
            int k = 0; //k用于定位
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val){
                    nums[k] = nums[i];
                    k ++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
            return k + 1;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int i = solution.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        System.out.println("结果：" + i);
    }
}
