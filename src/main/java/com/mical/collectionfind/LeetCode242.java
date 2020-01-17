package com.mical.collectionfind;

import org.junit.Test;

import java.util.HashMap;

/**
 * 类 名 称：LeetCode242
 * 类 描 述：力扣网242题（349题、250题）
 * 题 描 述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输 入: s = "anagram", t = "nagaram"
 * 输 出: true
 * 创建时间：2020/1/16 21:42
 * 创建人：Mical
 */
public class LeetCode242 {

    class Solution {
        //使用数组来记录频率的方式
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;

            int[] freq = new int[26];
            for (char c : t.toCharArray()) {
                freq[c - 'a']++;
            }

            for (char c : s.toCharArray()) {
                if (freq[c - 'a'] > 0) {
                    freq[c - 'a']--;
                } else {
                    return false;
                }
            }
            return true;
        }

        //使用Map来记录频率
        public boolean isAnagram1(String s, String t){
            if (s.length() != t.length())
                return false;
            HashMap<Character, Integer> map = new HashMap<>();
            //先记录t的字母频率
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            //再判断s的字母频率
            for (char c : s.toCharArray()) {
                Integer integer = map.get(c);
                if (integer == null || integer <= 0)
                    return false;
                map.put(c, integer - 1);
            }
            return true;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        boolean anagram = solution.isAnagram1("ccac", "aacc");
        System.out.println(anagram);
    }
}
