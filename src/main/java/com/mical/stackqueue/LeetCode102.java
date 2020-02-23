package com.mical.stackqueue;

import org.junit.Test;

import java.util.*;

/**
 * 类 名 称：LeetCode102
 * 类 描 述：力扣网102题：二叉树的层序遍历（107题）
 * 题 描 述：给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 输 入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输 出：[ [3], [9,20], [15,7] ]
 * 创建时间：2020/2/23 11:24
 * 创建人：Mical
 */
public class LeetCode102 {
    class Solution {
        //非递归写法，利用队列。
        public List<List<Integer>> levelOrder1(TreeNode root) {
            List<List<Integer>> list = new ArrayList();
            if (root == null) {
                return list;
            }

            //声明一个队列
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            //定义初始层级数
            int level = 0;
            //每次while循环都取出里面所有元素并将树下一层元素放进去。
            while (!queue.isEmpty()) {
                list.add(new ArrayList<>());
                //表示当前层中有多少个数
                int levelLength = queue.size();
                for (int i = 0; i < levelLength; i++) {
                    TreeNode node = queue.poll();
                    list.get(level).add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                level++;
            }
            return list;
        }

        //递归解法。
        public List<List<Integer>> levelOrder2(TreeNode root) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            levelOrderHelper(list, root, 0);
            return list;
        }

        public void levelOrderHelper(List<List<Integer>> resList, TreeNode node, int level){
            if (node == null){
                return;
            }
            //当层级和集合的大小相等，说明集合少一个，需要新添加一个集合。
            if (level == resList.size()){
                ArrayList<Integer> integers = new ArrayList<>();
                resList.add(integers);
            }

            if (node.left != null) levelOrderHelper(resList, node.left, level + 1);
            if (node.right != null) levelOrderHelper(resList, node.right, level + 1);
            resList.get(level).add(node.val);
        }
    }

    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Solution solution = new Solution();
        solution.levelOrder2(treeNode);
    }
}
