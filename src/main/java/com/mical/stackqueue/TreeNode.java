package com.mical.stackqueue;

/**
 * 类 名 称：TreeNode
 * 类 描 述：二叉树节点
 * 创建时间：2020/2/21 12:05
 * 创建人：Mical
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
