package com.mical.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 类 名 称：LeetCode94
 * 类 描 述：力扣网94题
 * 题 描 述：给定一个二叉树，返回它的中序 遍历。
 * 创建时间：2020/2/21 13:57
 * 创建人：Mical
 */
public class LeetCode94 {

    class Solution {
        //解法一：递归版
        public List<Integer> inorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorderHelp(list, root);
            return list;
        }

        public void inorderHelp(List<Integer> list, TreeNode node) {
            if (node == null) {
                return;
            }
            inorderHelp(list, node.left);
            list.add(node.val);
            inorderHelp(list, node.right);
        }

        //解法二：非递归版
        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;

            //插入栈操作
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }

            return list;
        }

        //解法三：简便非递归版
        public List<Integer> inorderTraversal3(TreeNode root) {
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
                    stack.push(new Command("print", command.node));
                    if (command.node.left != null){
                        stack.push(new Command("go", command.node.left));
                    }
                }
            }
            return list;
        }
    }
}
