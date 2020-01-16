package com.mical.collectionfind;

import org.junit.Test;

import java.util.*;

/**
 * 类 名 称：LeetCode350
 * 类 描 述：力扣网350题（349题、242题）
 * 题 描 述：给定两个数组，编写一个函数来计算它们的交集。
 * 输 入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输 出: [2,2]
 * 创建时间：2020/1/16 20:58
 * 创建人：Mical
 */
public class LeetCode350 {

    class Solution{

        //使用Map记录元素出现的次数，此处出现的 map.getOrDefault 我是第一次接触，又学到新东西了。
        public int[] intersect(int[] nums1, int[] nums2){

            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i1 : nums1) {
                hashMap.put(i1, hashMap.getOrDefault(i1, 0) + 1);
            }

            int k = 0;
            for (int i : nums2) {
                Integer integer = hashMap.getOrDefault(i, 0);
                if (integer > 0){
                    nums1[k ++] = i;
                    hashMap.put(i, integer - 1);
                }
            }

            return Arrays.copyOfRange(nums1, 0, k);
        }
    }

    @Test
    public void text(){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Integer orDefault = hashMap.getOrDefault(4, 0);
        Integer integer = hashMap.get(4);
        System.out.println(integer);
    }
}
