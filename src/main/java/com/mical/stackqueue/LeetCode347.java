package com.mical.stackqueue;

import org.junit.Test;

import java.util.*;

/**
 * 类 名 称：LeetCode347
 * 题 描 述：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 输 入：nums = [1,1,1,2,2,3], k = 2
 * 输 出：[1, 2]
 * 创建时间：2020/2/28 10:13
 * 创建人：Mical
 */
public class LeetCode347 {

    class Node {
        int freq;
        int val;

        public Node(int freq, int val) {
            this.freq = freq;
            this.val = val;
        }
    }

    class Solution {
        //使用优先队列
        public List<Integer> topKFrequent(int[] nums, int k) {
            //统计每个元素出现的频率，key为数值，value为频率
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                Integer number = freq.getOrDefault(num, 0);
                freq.put(num, number + 1);
            }

            //扫描freq，维护当前出现频率最高的k个元素
            //此处维护的是最小优先队列，因为这样小的会往队首冒，然后弹出去的都是最小的。
            PriorityQueue<Node> queue = new PriorityQueue<>(k, Comparator.comparingInt(node -> node.freq));
            freq.forEach((key, value) -> {
                if (queue.size() == k) {
                    if (value > queue.peek().freq) {
                        queue.poll();
                        queue.offer(new Node(value, key));
                    }
                } else {
                    queue.offer(new Node(value, key));
                }
            });

            ArrayList<Integer> integers = new ArrayList<>();
            while (!queue.isEmpty()) {
                integers.add(queue.poll().val);
            }
            return integers;
        }

        //使用队列，一样可以对频率进行排序
        public List<Integer> topKFrequent2(int[] nums, int k) {
            //统计每个元素出现的频率，key为数值，value为频率
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                Integer number = freq.getOrDefault(num, 0);
                freq.put(num, number + 1);
            }

            ArrayList<Node> nodes = new ArrayList<>(freq.size());
            freq.forEach((key, value) -> {
                nodes.add(new Node(value, key));
            });
            nodes.sort((node1, node2) -> {
                return node2.freq - node1.freq;
            });

            ArrayList<Integer> integers = new ArrayList<>(k);
            for (int i = 0; i < k; i++) {
                integers.add(nodes.get(i).val);
            }
            return integers;
        }
    }

    @Test
    public void test () {
        Solution solution = new Solution();
        List<Integer> integers = solution.topKFrequent2(new int[]{4,1,-1,2,-1,2,3 }, 2);
        System.out.println(integers);
    }
}
