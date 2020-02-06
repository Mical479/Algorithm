package com.mical.collectionfind;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类 名 称：LeetCode447
 * 类 描 述：力扣网447题：回旋镖的数量
 * 题 描 述：给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * 输 入：[[0, 0], [1, 0], [2, 0]]
 * 输 出：2
 * 创建时间：2020/1/25 18:22
 * 创建人：Mical
 */
public class LeetCode447 {

    class Solution{
        //遍历两遍，分别计算其他点到该点的距离，使用map保存距离和出现距离一样的频率，再遍历map将频率大于2的计算出可能出现的路径
        public int numberOfBoomeranges(int[][] points){
            AtomicInteger res = new AtomicInteger();
            for (int i = 0; i < points.length; i++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (j != i){
                        int distance = distance(points[i], points[j]);
                        map.put(distance, map.getOrDefault(distance, 0) + 1);
                    }
                }

                map.forEach((key, value) -> {
                    if (value >= 2)
                        res.addAndGet(value * (value - 1));
                });
            }
            return res.get();
        }

        private int distance(int[] i, int[] j){
            return (j[0] - i[0]) * (j[0] - i[0]) +
                    (j[1] - i[1]) * (j[1] - i[1]);
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int i = solution.numberOfBoomeranges(new int[][]{{0, 0}, {1, 0}, {2, 0}});
        System.out.println(i);
    }
}
