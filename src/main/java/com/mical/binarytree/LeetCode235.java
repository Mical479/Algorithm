package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode235
 * 题 名 称：二叉搜索树的最近公共祖先
 * 题 描 述：对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * 输 入：root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输 出：6
 * 创建时间：2020/3/2 10:55
 * 创建人：Mical
 */
public class LeetCode235 {
    class Solution {
        //利用二叉搜索树，需要明确两种情况
        //1、当 p 和 q 分别在 root 的两侧，说明root就是他们的最近公共祖先
        //2、当p和q都在root的一侧，说明他们的最近公共祖先要在那一侧去寻找
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;

            if (p.val < root.val && q.val < root.val)
                return lowestCommonAncestor(root.left, p, q);
            if (p.val > root.val && q.val > root.val)
                return lowestCommonAncestor(root.right, p, q);
            return root;
        }
    }

    @Test
    public void test() {
        TreeNode node = TreeNode.createNode(new int[]{6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5});
        System.out.println("jj");
    }
}
