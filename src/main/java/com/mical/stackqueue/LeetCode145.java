package com.mical.stackqueue;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 类 名 称：LeetCode145
 * 类 描 述：力扣网145题
 * 题 描 述：给定一个二叉树，返回它的 后序 遍历。
 * 创建时间：2020/2/21 14:28
 * 创建人：Mical
 */
public class LeetCode145 {

    class Solution {
        //解法一：递归版
        public List<Integer> postorderTraversal1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            postorderHelper(list, root);
            return list;
        }

        public void postorderHelper(List<Integer> list, TreeNode node) {
            if (node == null) {
                return;
            }
            postorderHelper(list, node.left);
            postorderHelper(list, node.right);
            list.add(node.val);
        }

        //解法二：非递归版;思路：将先序遍历改成 center -> right -> left。
        // 遍历后，在逆序数组，即可变成 left -> right -> center。
        public List<Integer> postorderTraversal2(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                list.addFirst(top.val);
                if (top.left != null) {
                    stack.push(top.left);
                }
                if (top.right != null) {
                    stack.push(top.right);
                }
            }
            return list;
        }

        //解法三：非递归简单版
        public List<Integer> postorderTraversal3(TreeNode root) {
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
                    stack.push(new Command("print", command.node));
                    if (command.node.right != null){
                        stack.push(new Command("go", command.node.right));
                    }
                    if (command.node.left != null){
                        stack.push(new Command("go", command.node.left));
                    }
                }
            }
            return list;
        }
    }
}
