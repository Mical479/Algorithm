package com.mical.collectionfind;

import org.junit.Test;

/**
 * 类 名 称：LeetCode205
 * 类 描 述：力扣网205题（209题）
 * 题 描 述：给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 输 入: s = "egg", t = "add"
 * 输 出: true
 * 创建时间：2020/1/17 21:15
 * 创建人：Mical
 */
public class LeetCode205 {

    class Solution{
        //解法一：通过遍历字符串，判断每个字符第一次出现的位置是否相等，即可判断两个字符串是否异构
        public boolean isIsomorphic(String s, String t){
            for (int i = 0; i < s.length(); i++) {
                if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i)))
                    return false;
            }
            return true;
        }

        //解法二：将每个字符映射成第三方的语言，再比较第三方是否相等。比如：abba --->1221，jddj ---> 1221，然后再判断后面两个是否相等。
        public boolean isIsomorphic1(String s, String t) {
            return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
        }

        private String isIsomorphicHelper(String s) {
            int[] map = new int[128];
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                //当前字母第一次出现,赋值
                if (map[c] == 0) {
                    map[c] = i + 1;
                }
                sb.append(map[c]);
            }
            return sb.toString();
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("paper", "title"));
    }
}
