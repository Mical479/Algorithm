package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;

/**
 * 类 名 称：LeetCode112
 * 题 名 称：路径总和
 * 题 描 述：给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 输 入：
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 输 出：true
 * 解 释：5 -> 4 -> 11 -> 2
 * 创建时间：2020/2/29 13:14
 * 创建人：Mical
 */
public class LeetCode112 {
    //需要判断叶子节点
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
