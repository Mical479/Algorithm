package com.mical.collectionfind;

import java.util.HashMap;

/**
 * 类 名 称：LeetCode454
 * 类 描 述：力扣网454题
 * 题 描 述：给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * 输 入：A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输 出：2
 * 创建时间：2020/1/24 17:19
 * 创建人：Mical
 */
public class LeetCode454 {

    class Solution{
        //使用map记录C和D数组的随机和，将算法结果将为 O(n^2) 的复杂度
        //时间复杂度O(n^2)
        //空间复杂度O(n^2)
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    Integer orDefault = map.getOrDefault(C[i] + D[j], 0) + 1;
                    map.put(C[i] + D[j], orDefault);
                }
            }
            //记录结果
            int res = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (map.get(-A[i]-B[j]) != null){
                        //添加记录在map中的次数
                        res += map.get(-A[i]-B[j]);
                    }
                }
            }
            return res;
        }
    }
}
