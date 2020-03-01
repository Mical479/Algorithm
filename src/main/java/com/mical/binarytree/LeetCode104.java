package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode104
 * 题 名 称：二叉树的最大深度(111题)
 * 题 描 述：给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
 * 输 入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输 出：3
 * 创建时间：2020/2/29 10:22
 * 创建人：Mical
 */
public class LeetCode104 {

    class Solution {
        //我自己写的垃圾算法
        public int maxDepth(TreeNode root) {
            return depthHelper(root, 0);
        }

        public int depthHelper(TreeNode node, int depth) {
            if (node == null) {
                return depth;
            }
            int leftDepth = depthHelper(node.left, depth + 1);
            int rightDepth = depthHelper(node.right, depth + 1);
            return Math.max(leftDepth, rightDepth);
        }

        //更简便的递归
        public int maxDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth2(root.left);
            int right = maxDepth2(root.right);
            return Math.max(left, right) + 1;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
//        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), null);
        solution.maxDepth(treeNode);
    }
}
