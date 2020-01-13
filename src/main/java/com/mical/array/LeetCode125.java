package com.mical.array;

import org.junit.Test;

/**
 * 类 名 称：LeetCode125
 * 类 描 述：力扣网125题(167题、345题、11题）
 * 题 描 述：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 输 入: "A man, a plan, a canal: Panama"
 * 输 出: true
 * 创建时间：2020/1/13 20:47
 * 创建人：Mical
 */
public class LeetCode125 {

    class Solution{
        /**
         *指针对撞法
         * @param s
         * @return
         */
        public boolean isPalindrome(String s){
            char[] arr = s.toLowerCase().toCharArray();
            int l = 0, r = arr.length - 1;
            while (l <= r){
                //判断该字符是否为 a-z 或者 数字
                if ((arr[l] >= 'a' && arr[l] <= 'z') || (arr[l] + 0 >= 48 && arr[l] <= 57)){
                    if ((arr[r] >= 'a' && arr[r] <= 'z') || (arr[r] + 0 >= 48 && arr[r] <= 57)){
                        if (arr[l] == arr[r]){
                            l ++;
                            r --;
                        }else {
                            return false;
                        }
                    }else {
                        r --;
                    }
                }else {
                    l++;
                }
            }
            return true;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("0P"));
    }
}


