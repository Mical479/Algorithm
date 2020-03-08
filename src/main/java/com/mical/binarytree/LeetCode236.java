package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;

/**
 * 类 名 称：LeetCode236
 * 题 名 称：二叉树的最近公共祖先 ( 235题的升级版）
 * 题 描 述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 输 入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输 出：3
 * 创建时间：2020/3/8 11:09
 * 创建人：Mical
 */
public class LeetCode236 {
    class Solution {
        TreeNode curNode = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            findNode(root, p, q);
            return curNode;
        }

        //递归查找节点。分别在当前节点的左子树，右子树查找，并比较当前节点。
        // 当找到节点时就返回true，之后就会从找到的节点向上回溯，为true。
        //当找到的情况大于或等于两种时，就将当前节点设置为最终返回节点。
        public boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return false;

            int left = findNode(root.left, p, q) ? 1 : 0;
            int right = findNode(root.right, p, q) ? 1 : 0;
            int mid = (root == p || root == q) ? 1 : 0;

            if (mid + left + right >= 2) {
                curNode = root;
            }

            return (mid + left + right) > 0;
        }
    }
}
