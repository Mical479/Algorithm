package com.mical.array;

import org.junit.Test;

/**
 * 类 名 称：LeetCode88
 * 类 描 述：力扣网88题
 * 题 描 述：给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * 创建时间：2020/1/12 20:28
 * 创建人：Mical
 */
public class LeetCode88 {

    class Solution{

        /**
         * 归并排序，从大到小排序
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n){

            int i = m - 1;
            int j = n - 1;
            int len = m + n - 1;

            while (i >= 0 && j >= 0){
                if (nums1[i] > nums2[j])
                    nums1[len--] = nums1[i--];
                else
                    nums1[len--] = nums2[j--];
            }

            //如果nums1在上面没轮询完，剩下的nums1本来就在里面，不用管
            //如果nums2在上面没轮询完，继续将nums2剩下的元素拷贝到nums1中去
            while (j >= 0){
                nums1[len --] = nums2[j --];
            }
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
