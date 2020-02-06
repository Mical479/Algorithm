package com.mical.collectionfind;

import org.junit.Test;

import java.util.*;

/**
 * 类 名 称：LeetCode49
 * 类 描 述：力扣网49题
 * 题 描 述：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 * 输 入：["eat", "tea", "tan", "ate", "nat", "abt"]
 * 输 出：[ ["ate", "eat", "tea"], ["nat", "tan"], ["bat"]]
 * 创建时间：2020/1/25 16:19
 * 创建人：Mical
 */
public class LeetCode49 {
    class Solution {
        //自己写的
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> list = new ArrayList<>(16);

            int l = 0;
            int r = l + 1;
            ArrayList<Integer> integers = new ArrayList<>();
            //排序数组，将strs中一样的放在一起，并将分界点记录在integers列表中
            while (l < strs.length - 1) {
                if (!isAnagrams(strs[l], strs[r])) {
                    if (r < strs.length - 1) {
                        r++;
                    } else {
                        integers.add(l);
                        l++;
                        r = l + 1;
                    }
                } else {
                    if (l + 1 < r) {
                        l++;
                        String temp = strs[r];
                        strs[r] = strs[l];
                        strs[l] = temp;
                    } else {
                        l++;
                    }
                    if (r < strs.length - 1)
                        r++;
                }
            }

            if (integers.size() == 1) {
                list.add(Arrays.asList(strs).subList(0, integers.get(0) + 1));
                list.add(Arrays.asList(strs).subList(integers.get(0) + 1, strs.length));
            } else if (integers.size() == 0) {
                list.add(Arrays.asList(strs));
            } else {
                for (int i = 0; i < integers.size(); i++) {
                    if (i == 0) {
                        list.add(Arrays.asList(strs).subList(0, integers.get(0) + 1));
                    } else if (i == integers.size() - 1) {
                        list.add(Arrays.asList(strs).subList(integers.get(i - 1) + 1, integers.get(i) + 1));
                        list.add(Arrays.asList(strs).subList(integers.get(i) + 1, strs.length));
                    } else {
                        list.add(Arrays.asList(strs).subList(integers.get(i - 1) + 1, integers.get(i) + 1));
                    }
                }
            }
            return list;
        }

        private boolean isAnagrams(String s, String p) {
            if (s.length() != p.length()) return false;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int i = 0; i < p.length(); i++) {
                Integer integer = map.get(p.charAt(i));
                if (integer == null || integer <= 0) {
                    return false;
                } else {
                    map.put(p.charAt(i), --integer);
                }
            }
            return true;
        }

        //别人写的,用for循环遍历strs中的每个字符串，将字符串排序后放入作为key放入map中，判断排序后作为key中Map是否含有。
        public List<List<String>> groupAnagrams1(String[] strs) {
            HashMap<String, List<String>> hash = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] s_arr = strs[i].toCharArray();
                //排序
                Arrays.sort(s_arr);
                //映射到 key
                String key = String.valueOf(s_arr);
                //添加到对应的类中
                if (hash.containsKey(key)) {
                    hash.get(key).add(strs[i]);
                } else {
                    List<String> temp = new ArrayList<String>();
                    temp.add(strs[i]);
                    hash.put(key, temp);
                }

            }
            return new ArrayList<List<String>>(hash.values());
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
//        boolean anagrams = solution.isAnagrams("eat", "taa");
        String[] strs = new String[]{ "", ""};
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println(lists);
    }
}
