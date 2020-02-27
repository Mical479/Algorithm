package com.mical.stackqueue;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 类 名 称：LeetCode127
 * 题 描 述：给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词
 * 输 入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输 出：5
 * 解 释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",返回它的长度 5。
 * 思 路：通过队列进行广度优先遍历，也就是一层一层的遍历。
 * 创建时间：2020/2/27 11:04
 * 创建人：Mical
 */
public class LeetCode127 {
    class Node {
        String word;
        int step;

        public Node(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            LinkedList<Node> queue = new LinkedList<>(); //声明一个队列里
            boolean[] visited = new boolean[wordList.size()]; //声明列表中的哪个单词是已经被访问过得
            queue.offer(new Node(beginWord, 1));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int step = node.step;
                String word = node.word;

                for (int i = 0; i < wordList.size(); i++) {
                    String s = wordList.get(i);
                    if (!visited[i] && ladder(word, s)){ //我去，这两个判断条件换一下，效率差了一倍我靠。
                        if (s.equals(endWord))
                            return step + 1;

                        queue.offer(new Node(s, step + 1));
                        visited[i] = true;
                    }
                }
            }
            return 0;
        }

        //判断两个字符串只有一个字符相等。这是可变换的。
        private boolean ladder(String s, String p) {
            int count = 0;
            if (s.length() != p.length())
                return false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == p.charAt(i))
                    count ++;
            }
            return count == s.length() - 1;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int i = solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(i);
    }
}
