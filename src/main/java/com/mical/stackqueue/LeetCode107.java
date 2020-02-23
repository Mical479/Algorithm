package com.mical.stackqueue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类 名 称：LeetCode107
 * 类 描 述：力扣网107题(102题)
 * 题 描 述：给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 输 入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输 出：[[15,7],[9,20],[3]]
 * 创建时间：2020/2/23 13:29
 * 创建人：Mical
 */
public class LeetCode107 {
    class Solution {
        //思路：可以在102题的基础之上直接反转列表即可
        //非递归解法
        public List<List<Integer>> levelOrderBottom(TreeNode root){
            LinkedList<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> levels = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    levels.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                //区别点：头插入
                result.addFirst(levels);
            }
            return result;
        }
    }

    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Solution solution = new Solution();
        solution.levelOrderBottom(treeNode);
    }
}
