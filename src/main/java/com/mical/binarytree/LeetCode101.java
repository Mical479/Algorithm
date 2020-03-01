package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode101
 * 题 名 称：对称二叉树
 * 题 描 述：给定一个二叉树，检查它是否是镜像对称的。
 * 输 入：
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 输 出：true
 * 创建时间：2020/2/29 11:50
 * 创建人：Mical
 */
public class LeetCode101 {
    //判断是否为镜像，可转换成判断两棵树是否互为镜像，镜像的判断则为一颗数的左子树等于另外一棵树的右子树。
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return symmetricHelper(root, root);
        }

        public boolean symmetricHelper(TreeNode left, TreeNode right) {
            if (left == null && right == null)
                return true;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;

            return symmetricHelper(left.right, right.left) && symmetricHelper(left.left, right.right);
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        solution.isSymmetric(treeNode);
    }
}
