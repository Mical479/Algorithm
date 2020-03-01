package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 类 名 称：LeetCode404
 * 题 名 称：左叶子之和
 * 题 描 述：计算给定二叉树的所有左叶子之和（最左边的，且是叶子节点）
 * 输 入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输 出：24（9+15）
 * 创建时间：2020/2/29 13:26
 * 创建人：Mical
 */
public class LeetCode404 {
    class Solution {
        //递归的同时，需要增加一个是否为左节点的标识位，只有标识位为真，且为叶子节点的节点才可以加
        public int sumOfLeftLeaves(TreeNode root) {
            return sumHelper(root, false);
        }

        public int sumHelper(TreeNode node, boolean flag) {
            if (node == null)
                return 0;

            if (flag && node.left == null && node.right == null)
                return node.val;
            return sumHelper(node.left, true) + sumHelper(node.right, false);
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.sumOfLeftLeaves(treeNode));
    }
}
