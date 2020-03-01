package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode100
 * 题 名 称：相同的树
 * 题 描 述：给定两个二叉树，编写一个函数来检验它们是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 * 输 出：true
 * 创建时间：2020/2/29 11:30
 * 创建人：Mical
 */
public class LeetCode100 {
    class Solution {
        //利用递归，需要注意的是，不能直接用 p == q 判断两个节点是否相等，而是要判断 两个节点的值是否相等。
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            if (p == null || q == null)
                return false;
            if (p.val != q.val)
                return false;

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.isSameTree(treeNode, treeNode));
    }
}
