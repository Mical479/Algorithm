package com.mical.array;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 类 名 称：LeetCode438
 * 类 描 述：力扣网438题（209题、3题、本题升华版76题）
 * 题 描 述：给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 输 入:s: "cbaebabacd" p: "abc"
 * 输 出:[0, 6]
 * 创建时间：2020/1/14 21:41
 * 创建人：Mical
 */
public class LeetCode438 {

    class Solution{
        public List<Integer> findAnagrams(String s, String p){
            LinkedList<Integer> res = new LinkedList<>();
            int[] freq = new int[26]; //定义ASCII码的数组，记录每个字符的频率
            for (char c : p.toCharArray()) {
                freq[c - 'a'] ++; //将p中每个字符的频率记录在freq中,之所以减a是为了保证ASCII码在0-26之间
            }
            char[] chars = s.toCharArray();
            int l = 0, r = 0; //定义chars[l...r] 的滑动窗口
            int len = p.length();
            //扩张窗口至p的长度大小
            while (r < p.length()){
                char temp = chars[r];
                freq[temp - 'a'] --; //记录s字符串头几个字符的频率
                if (freq[temp - 'a'] >= 0) //如果上面减了后还大于等于0，说明p中存在该字符，将len减1
                    len --;
                r ++;
            }
            if (len == 0) //如果len等于0了，说明开头就匹配上p了
                res.add(0);

            //len的大小表示还需要匹配多少个元素就合规了
            //开始滑动窗口,每次滑动窗口，左边元素被移出，右边元素被添加。
            //当移除操作时，窗口中会少一个元素，所以对应频率增加，如果该元素在p里面，所以应多匹配一个元素，长度增加，
            //当添加操作时，窗口中刚刚好对应长度个元素，所以对应频率减小，对应长度减小
            while (r < s.length()){
                //左边的拿出来一个,更新左边字符的频率和p的长度
                if (freq[chars[l] - 'a'] >= 0){
                    len ++;
                }
                freq[chars[l] - 'a'] ++;
                l ++;
                //右边的拿进来一个
                freq[chars[r] - 'a'] --;
                if (freq[chars[r] - 'a'] >= 0)
                    len --;
                r ++;
                if (len == 0)
                    res.add(l);
            }
            return res;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        List<Integer> anagrams = solution.findAnagrams("cbabacd", "abc");
        System.out.println(anagrams);
    }
}
