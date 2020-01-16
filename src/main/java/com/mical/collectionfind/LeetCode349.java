package com.mical.collectionfind;

import org.junit.Test;

import java.util.*;

/**
 * 类 名 称：LeetCode349
 * 类 描 述：力扣网349题（350题、242题）
 * 题 描 述：给定两个数组，编写一个函数来计算它们的交集。
 * 输 入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输 出: [2]
 * 创建时间：2020/1/16 20:18
 * 创建人：Mical
 */
public class LeetCode349 {

    class Solution{

        //解法1：声明一个set将数组1全部放进去，然后遍历数组2，利用 set.contains(o) 去查找数组2中的每个元素，如果找到，放入新的set中去
        //LeetCode上，内置函数反而没有解法1快，但解法1空间用的更多
        public int[] intersection(int[] nums1, int[] nums2){
            HashSet<Integer> set1 = new HashSet<>();

            for (int i : nums1) {
                set1.add(i);
            }

            HashSet<Integer> set2 = new HashSet<>();
            for (int i = 0; i < nums2.length; i++) {
                if (set1.contains(nums2[i]))
                    set2.add(nums2[i]);
            }

            int[] res = new int[set2.size()];

            int i = 0;
            for (Integer integer : set2) {
                res[i++] = integer;
            }

            return res;
        }

        //解法2：使用内置函数
        public int[] intersection2(int[] nums1, int[] nums2){
            HashSet<Integer> integers = new HashSet<>();
            HashSet<Integer> integers1 = new HashSet<>();

            for (int i : nums1) {
                integers.add(i);
            }

            for (int i : nums2) {
                integers1.add(i);
            }
            //利用内置函数将不包含 integer1 的元素全部去除
            integers.retainAll(integers1);
            int[] res = new int[integers.size()];
            int i = 0;
            for (Integer integer : integers) {
                res[i++] = integer;
            }
            return res;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int[] intersection = solution.intersection2(new int[]{1,2,2,1}, new int[]{2,2});
        for (int i : intersection) {
            System.out.println(i);
        }
    }
}
