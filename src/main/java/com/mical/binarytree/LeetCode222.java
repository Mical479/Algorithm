package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;

/**
 * 类 名 称：LeetCode222
 * 题 名 称：完全二叉树的节点个数
 * 题 描 述：给出一个完全二叉树，求出该树的节点个数。
 * 输 入：
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * 输 出：6
 * 创建时间：2020/2/29 12:45
 * 创建人：Mical
 */
public class LeetCode222 {
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null)
                return 0;
            int left = countNodes(root.left); //求左子树的节点个数
            int right = countNodes(root.right); //求右子树的节点个数
            return left + right + 1; //左子树节点个数 + 右子树节点个数 + 当前节点 = 总节点个数
        }
    }
}
