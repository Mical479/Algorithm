package com.mical.array;

import org.junit.Test;

/**
 * 类 名 称：LeetCode345
 * 类 描 述：力扣网345题（125题、167题、11题）
 * 题 描 述：编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 输 入: "hello"
 * 输 出: "holle"
 * 创建时间：2020/1/13 21:20
 * 创建人：Mical
 */
public class LeetCode345 {
    class Solution {
        /**
         * 双指针碰撞法
         * @param s
         * @return
         */
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            char[] chars2 = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
            int l = 0, r = chars.length - 1;
            while (l < r) {
                if (equalsVowels(chars2, chars[l])) {
                    if (equalsVowels(chars2, chars[r])) {
                        char temp = chars[l];
                        chars[l] = chars[r];
                        chars[r] = temp;
                        r--;
                        l++;
                    } else {
                        r--;
                    }
                } else {
                    l++;
                }
            }
            return new String(chars);
        }

        /**
         * 判断是否为元音字母
         * @param chars
         * @param c
         * @return
         */
        private boolean equalsVowels(char[] chars, char c) {
            for (char aChar : chars) {
                if (aChar == c)
                    return true;
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        String hello = solution.reverseVowels("hello");
        System.out.println(hello);
    }
}
