package com.mical.array;

/**
 * 类 名 称：LeetCode3
 * 类 描 述：力扣网第3题（209题、438题、76题）
 * 题 描 述：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输 入: "abcabcbb"
 * 输 出: 3
 * 解 释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 创建时间：2020/1/14 21:00
 * 创建人：Mical
 */
public class LeetCode3 {

    class Solution{
        /**
         * 滑动窗口
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s){
            char[] chars = s.toCharArray();
            int[] freq = new int[256]; //定义ASI码的数组，如果某个字符串有值，就将对应位置加加，记录该字符的频率,
            int length = 0; //要求最长子串，将窗口定义为最小的值
            int l = 0, r = -1; //滑动窗口为 chars[l...r] 区间

            //右指针滑动：当频率为0，即下个值没重复的情况下
            //左指针滑动：有重复值时，不断滑动，至重复值被移除区间
            while (l < chars.length){ //必须左区间移动到最右边才能结束循环
                if (r + 1 < chars.length && freq[chars[r + 1]] == 0){ //这里注意判断条件不能变换，应该先判断 r+1
                    r ++;
                    freq[chars[r]] ++;
                }else {
                    freq[chars[l]] --;
                    l++;
                }
                length = Math.max(length, r - l + 1); //之所以不用判断就取值，是因为一旦右指针取到重复值后，左边界就会不断右移，区间减小，length不会更新。
            }
            return length;
        }
    }
}
