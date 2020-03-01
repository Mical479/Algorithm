package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode110
 * 题 名 称：平衡二叉树
 * 题 描 述：给定一个二叉树，判断它是否是高度平衡的二叉树。平衡二叉树：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 输 入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输 出：true
 * 创建时间：2020/2/29 12:52
 * 创建人：Mical
 */
public class LeetCode110 {
    class Solution {
        //思路：判断该树的左右子树的高度，通过比较高度差来判断。但是，不能简单的只比较根节点，需要对每个节点都进行判断
        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            return Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int treeHeight(TreeNode node) {
            return node == null ? 0 : Math.max(treeHeight(node.left), treeHeight(node.right)) + 1;
        }
    }

    @Test
    public void test () {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        System.out.println(solution.isBalanced(treeNode));
    }
}
