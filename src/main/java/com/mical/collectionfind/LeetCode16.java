package com.mical.collectionfind;

import org.junit.Test;

import java.util.Arrays;

/**
 * 类 名 称：LeetCode16
 * 类 描 述：力扣网16题
 * 题 描 述：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 输 入：nums = [ -1, 2, 1, -4 ], target = 1
 * 输 出：2
 * 创建时间：2020/1/24 16:12
 * 创建人：Mical
 */
public class LeetCode16 {

    class Solution{
        //可以参考三数之和的问题，是一样的
        //i 从0开始遍历，在i的右边的区间使用双指针碰撞的技术去计算三个值的和
        public int threeSumClosest(int[] nums, int target){
            Arrays.sort(nums);
            //记录值最接近的和
            int res = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 1; i++) {
                //如果值一样就去重撒
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                //定义碰撞指针
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r){
                    int temp = nums[i] + nums[l] + nums[r];
                    if (Math.abs(temp - target) < Math.abs(res - target)){
                        res = temp;
                    }
                    if (temp > target){
                        r --;
                    }else if (temp < target){
                        l ++;
                    }else {
                        return res;
                    }
                }
            }
            return res;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int i = solution.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1);
        System.out.println(i);
    }
}
