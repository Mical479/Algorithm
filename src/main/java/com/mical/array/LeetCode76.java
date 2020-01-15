package com.mical.array;

import org.junit.Test;

/**
 * 类 名 称：LeetCode76
 * 类 描 述：力扣网76题（438题升华版、3题、209题）
 * 题 描 述：给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 输 入: S = "ADOBECODEBANC", T = "ABC"
 * 输 出: "BANC"
 * 创建时间：2020/1/14 22:55
 * 创建人：Mical
 */
public class LeetCode76 {

    class Solution{
        public String minWindow(String s, String t){

            if (s.length() < t.length())
                return "";

            int len = s.length() + 1; //记录最小子串长度
            int left = 0, right = 0; //记录最小子串的左右索引，方便最后返回子串
            int[] freq = new int[256]; //定义字符频率数组
            int count = t.length(); //t.length - count 为子串中出现t中字符的次数，当count为0时，出现所有t的字符，包含t
            int l = 0, r = -1; //定义滑动窗口的左右指针

            //先记录t中出现字符的频率
            for (char c : t.toCharArray()) {
                freq[c] ++;
            }

            //s包含t则s子串至少要大于等于t
            //固要先将滑动窗口扩张至 t 的长度
            while (r + 1 < t.length()){
                r ++;
                freq[s.charAt(r)] --;
                if (freq[s.charAt(r)] >= 0)
                    count --;
            }

            //说明前几个字母就已经包含t串了
            if (count == 0){
                return s.substring(l, r + 1);
            }

            //开始滑动窗口了
            //右指针移动：当 (窗口长度）r - l + 1 <= t.length() 或者 count > 0，前提是右指针能够移动（r <= s.length)
            //左指针移动：右指针不动就左指针动
            // 当左指针移动到最后 t.length() 的位置还没匹配到，就不移动了
            while (l <= s.length() - t.length()){
                if (r + 1 < s.length() && ( r -l + 1 <= t.length() || count > 0 )){
                    r ++;
                    freq[s.charAt(r)] --;
                    if (freq[s.charAt(r)] >= 0)
                        count --;
                }else {
                    if (freq[s.charAt(l)] >= 0) //左指针移动时，应该先判断该指针处的元素是否处于t串中
                        count ++;
                    freq[s.charAt(l)] ++;
                    l ++;
                }
                //滑动后判断是否满足条件
                if (count == 0 && len > r - l + 1){
                    len = r - l + 1;
                    left = l;
                    right = r;
                }
            }

            //如果子串没变，就返回空串
            if (len == s.length() + 1){
                return "";
            }
            return s.substring(left, right + 1);
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        String s = solution.minWindow("a", "a");
        System.out.println(s);
    }
}
