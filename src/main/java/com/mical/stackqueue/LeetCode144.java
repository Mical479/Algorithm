package com.mical.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 类 名 称：LeetCode144
 * 类 描 述：力扣网144题
 * 题 描 述：给定一个二叉树，返回它的 前序 遍历。
 * 输 入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输 出：[1,2,3]
 * 创建时间：2020/2/21 12:04
 * 创建人：Mical
 */
public class LeetCode144 {
    class Solution {
        //解法一：递归版
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            preorderHelper(list, root);
            return list;
        }

        public void preorderHelper(List<Integer> list, TreeNode node) {
            if (node == null) {
                return;
            }
            list.add(node.val);
            preorderHelper(list, node.left);
            preorderHelper(list, node.right);
        }

        //解法二：非递归实现
        public List<Integer> preorderTraversal2(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return list;
        }

        //解法三：超级非递归版
        public List<Integer> preorderTraversal3(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<Command> stack = new Stack<>();
            stack.push(new Command("go", root));

            while (!stack.isEmpty()) {
                Command command = stack.pop();

                if (command.mark.equals("print")){
                    list.add(command.node.val);
                } else {
                    if (command.node.right != null){
                        stack.push(new Command("go", command.node.right));
                    }
                    if (command.node.left != null){
                        stack.push(new Command("go", command.node.left));
                    }
                    stack.push(new Command("print", command.node));
                }
            }
            return list;
        }
    }
}
