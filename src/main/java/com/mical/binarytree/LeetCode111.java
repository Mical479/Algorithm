package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode111
 * 题 名 称：二叉树的最小深度（104题）
 * 题 描 述：给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 输 入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输 出：2
 * 创建时间：2020/2/29 10:38
 * 创建人：Mical
 */
public class LeetCode111 {
    class Solution {
        //递归算法，需要注意的是当根节点只有左子树或者只有右子树的情况下，数的最短长度并不是1。
        public int minDepth(TreeNode root) {
            //这个判断只是针对刚刚传入进来的root，判断它是否为空。
            if (root == null)
                return 0;
            //这才是递归时真正进行判断的
            if (root.left == null && root.right == null)
                return 1;
            int min = Integer.MAX_VALUE;
            if (root.left != null)
                min = Math.min(minDepth(root.left), min);

            if (root.right != null)
                min = Math.min(minDepth(root.right), min);
            return min + 1;
        }
    }

    @Test
    public void test () {
        Solution solution = new Solution();
//        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(3)), null);
        System.out.println(solution.minDepth(treeNode));
    }
}
