package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;

/**
 * 类 名 称：LeetCode226
 * 创建时间：2020/2/29 11:19
 * 创建人：Mical
 */
public class LeetCode226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.left == null && root.right == null)
                return root;
            //先翻转左右两颗子树
            invertTree(root.left);
            invertTree(root.right);
            //再进行左右节点的交换。
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }
    }
}
