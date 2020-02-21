package com.mical.stackqueue;

import org.junit.Test;

import java.util.Stack;

/**
 * 类 名 称：LeetCode20
 * 类 描 述：力扣网20题
 * 题 描 述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 输 入："()[]{}"
 * 输 出：true
 * 创建时间：2020/2/21 10:19
 * 创建人：Mical
 */
public class LeetCode20 {
    class Solution {
        //思路，遇到左括号就压入栈中，遇到右括号就进行判断
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else {
                    if (stack.size() == 0)
                        return false;
                    Character top = stack.pop();
                    Character match;
                    switch (top){
                        case '{':
                            match = '}';
                            break;
                        case '(':
                            match = ')';
                            break;
                        case '[':
                            match = ']';
                            break;
                        default:
                            return false;
                    }
                    if (match != s.charAt(i))
                        return false;
                }
            }
            return stack.size() == 0;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.isValid("{}");
    }
}
