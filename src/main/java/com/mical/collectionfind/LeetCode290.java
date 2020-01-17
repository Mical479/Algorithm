package com.mical.collectionfind;

import org.junit.Test;

import java.util.HashMap;

/**
 * 类 名 称：LeetCode290
 * 类 描 述：力扣网290题(205题）
 * 题 描 述：给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 输 入: pattern = "abba", str = "dog cat cat dog"
 * 输 出: true
 * 创建时间：2020/1/17 20:09
 * 创建人：Mical
 */
public class LeetCode290 {

    //解法：主要都是通过遍历pattern，对比两个字符串中第一个元素出现位置是否相等来判断。
    class Solution {

        //解法一：使用 indexOf 的方法，遍历 pattern ，如果pattern中的每个字符的第一次出现的位置和str中每个字符串第一次出现的位置一样，就通过
        public boolean wordPattern(String pattern, String str) {
            String[] arr = str.split(" ");
            if (pattern.length() != arr.length) return false;
            int len = pattern.length();
            for (int i = 0; i < len; i++) {
                if(pattern.indexOf(pattern.charAt(i)) != indexOf(arr, arr[i])){
                    return false;
                }
            }
            return true;
        }

        public int indexOf(String[] arrays, String searchString) {
            int ans = -1;
            for(int i = 0; i < arrays.length; i++) {
                if (arrays[i].equals(searchString)) {
                    ans = i;
                    break;
                }
            }
            return ans;
        }

        //解法二：使用Map记录每个元素第一次出现的位置，再遍历数组的每个元素，对比两个Map中的位置是否相等
        public boolean wordPattern1(String pattern, String str){
            HashMap<Character, Integer> patternMap = new HashMap<>();
            HashMap<String, Integer> strMap = new HashMap<>();

            String[] s = str.split(" ");
            if (s.length != pattern.length()) return false;

            int index = 0;
            for (char c : pattern.toCharArray()) {
                if (!patternMap.containsKey(c))
                    patternMap.put(c, ++index);
            }

            index = 0;
            for (String s1 : s) {
                if (!strMap.containsKey(s1))
                    strMap.put(s1, ++ index);
            }

            for (int i = 0; i < s.length; i++) {
                if (!patternMap.get(pattern.charAt(i)).equals(strMap.get(s[i])))
                    return false;
            }

            return true;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abaaba", "dog cat dog dog cat dog"));
    }
}
