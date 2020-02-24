package com.mical.stackqueue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类 名 称：LeetCode279
 * 题 描 述：给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 输 入：n = 13
 * 输 出：2
 * 解 释：13 = 4 + 9
 * 创建时间：2020/2/24 10:24
 * 创建人：Mical
 */
public class LeetCode279 {
    private class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    class Solution {
        public int numSquares(int n) {
            Queue<Node> quque = new LinkedList<>();
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(new Node(n, 1));
            boolean visited[] = new boolean[n];
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int val = node.val;
                int step = node.step;
                //每一层的广度遍历
                for (int i = 1; ; i++) {
                    int num = val - i * i;
                    //说明已经到此数的最大平方数
                    if (num < 0) {
                        break;
                    }
                    //由于是广度遍历，所以当遍历到0时，肯定是最短路径
                    if (num == 0) {
                        return step;
                    }

                    //当再次出现时没有必要加入，因为在该节点的路径长度肯定不小于第一次出现的路径长度。
                    if(!visited[num]) {
                        queue.offer(new Node(num, step + 1));
                        visited[num] = true;
                    }
                }
            }
            return -1;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.numSquares(13);
    }
}
