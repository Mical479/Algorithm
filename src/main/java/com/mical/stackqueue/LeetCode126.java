package com.mical.stackqueue;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 类 名 称：LeetCode126
 * 题 描 述：给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说 明：如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 输 入：beginWord = "hit",endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输 出：[ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"]]
 * 创建时间：2020/2/27 11:47
 * 创建人：Mical
 */
public class LeetCode126 {

    class Solution {
        //这个东西太难了，我的超时了。
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordLis) {
            List<List<String>> lists = new ArrayList<>();

            LinkedList<List<String>> queue = new LinkedList<>();
            ArrayList<String> strings = new ArrayList<>();
            strings.add(beginWord);
            queue.offer(strings);
            lists.add(strings);
            //先广度遍历所有结果
            while (!queue.isEmpty()) {
                List<String> poll = queue.poll();
                boolean isOk = false;
                boolean ok = false;
                int count = 0; //标志是否裂开
                String top = poll.get(poll.size() - 1);
                for (String s : wordLis) {
                    if (poll.contains(s))
                        continue;
                    //如果找到了两个字符串只相差一个字母，就将ok换为true。
                    if (ladder(top, s)) {
                        ok = true;
                        count++;
                        //如果裂开，就说明同一个地方有两个分支，需要将之前已经添加过的元素删除
                        if (count > 1) {
                            ArrayList<String> poll2 = new ArrayList<>(poll);
                            poll2.remove(poll2.size() - 1);
                            poll2.add(s);
                            lists.add(poll2);
                            if (!s.equals(endWord))
                                queue.offer(poll2);
                            continue;
                        }
                        poll.add(s);
                        if (s.equals(endWord)) {
                            isOk = true;
                            break;
                        }
                    }
                }
                //如果ok为true即已经遍历到根了，且没有遍历到最后的cog，才插入队列。
                if (!isOk && ok)
                    queue.offer(poll);
            }
            //再对结果进行过滤，先记录遍历长度最小的长度
            int count = Integer.MAX_VALUE;
            for (List<String> list : lists) {
                count = Math.min(count, list.size());
            }

            int finalCount = count;
            List<List<String>> list = lists.stream().filter(item -> item.size() == finalCount && item.get(item.size() - 1).equals(endWord)).collect(Collectors.toList());
            return list;
        }
        //两个字符串是否只相差一个字母
        private boolean ladder(String s, String p) {
            int count = 0;
            if (s.length() != p.length())
                return false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == p.charAt(i))
                    count++;
            }
            return count == s.length() - 1;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<String>> ladders = solution.findLadders("hot", "dog", Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"));
        System.out.println(ladders);
    }
}
