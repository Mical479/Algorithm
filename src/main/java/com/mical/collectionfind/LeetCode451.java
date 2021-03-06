package com.mical.collectionfind;

import org.junit.Test;

import java.util.*;

/**
 * 类 名 称：LeetCode451
 * 类 描 述：力扣网451题
 * 题 描 述：给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 输 入: "tree"
 * 输 出: "eert"
 * 创建时间：2020/1/19 20:19
 * 创建人：Mical
 */
public class LeetCode451 {

    class Solution{
        //先使用Map记录每个字符出现的频率，在用List将Map的每个Entry包装起来，自定义比较器，使用list自带的sort函数进行比较
        public String frequencySort(String s){
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());

            entries.sort((arg1, arg2) -> arg2.getValue().compareTo(arg1.getValue()));

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : entries) {
                for (int i = 0; i < entry.getValue(); i++) {
                    sb.append(entry.getKey());
                }
            }

            return sb.toString();
        }

        //利用Map记录频率，再声明一个数组，利用频率当下标，将字符放进去，再倒叙遍历数组即可（桶排序），但是没执行成功，哈哈
        public String frequencySort1(String s){
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            String[] ch = new String[s.length() + 1];

            map.forEach((key, value) -> {
                //这是频率一样的拼接在一起
                if (ch[value] != null){
                    ch[value] += key;
                }else {
                    //当一个字母的频率大于1时，应该拼接
                    if (value > 1){
                        ch[value] = "";
                        for (int i = 0; i < value; i++) {
                           ch[value] += key;
                        }
                    }else {
                        ch[value] = String.valueOf(key);
                    }
                }
            });

            StringBuilder sb = new StringBuilder();

            for (int i = ch.length - 1; i >= 0; i--) {
               if (ch[i] != null){
                   sb.append(ch[i]);
               }
            }
            return sb.toString();
        }

    }

    @Test
    public void test(){
        Solution solution = new Solution();
    }

}
