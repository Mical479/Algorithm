package com.mical.stackqueue;

import org.junit.Test;

import java.util.Stack;

/**
 * 类 名 称：LeetCode150
 * 类 描 述：力扣网150题
 * 题 描 述：根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 输 入：["2", "1", "+", "3", "*"]
 * 输 出：9
 * 解 释：((2 + 1) * 3) = 9
 * 创建时间：2020/2/21 10:53
 * 创建人：Mical
 */
public class LeetCode150 {
    class Solution {
        //思路：遇到操作符弹出前两个字符，遇到数字就压入栈中
        public int evalRPN(String[] tokens) {
            Stack<String> stack = new Stack<>();
            for (String token : tokens) {
                switch (token) {
                    case "+": {
                        int n1 = Integer.parseInt(stack.pop());
                        int n2 = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(n1 + n2));
                        break;
                    }
                    case "-": {
                        int n1 = Integer.parseInt(stack.pop());
                        int n2 = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(n2 - n1));
                        break;
                    }
                    case "*": {
                        int n1 = Integer.parseInt(stack.pop());
                        int n2 = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(n1 * n2));
                        break;
                    }
                    case "/": {
                        int n1 = Integer.parseInt(stack.pop());
                        int n2 = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(n2 / n1));
                        break;
                    }
                    default:
                        stack.push(token);
                }
            }
            return Integer.parseInt(stack.pop());
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int i = solution.evalRPN(new String[]{"4","13","5","/","+"});
        System.out.println(i);
    }
}
