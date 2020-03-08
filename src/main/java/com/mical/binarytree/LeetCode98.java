package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode98
 * 题 名 称：验证二叉搜索树
 * 题 描 述：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 输 入：
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输 出：false
 * 创建时间：2020/3/2 11:56
 * 创建人：Mical
 */
public class LeetCode98 {
    class Solution {
        //第一映像是只需要判断每棵树的左节点小于根节点，右节点大于根节点就行了
        //但是，还需要全局的判断。
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        //向左遍历需要上界，向右遍历需要下界。所以需要保存。
        //以根节点为例，需要判断它大于上界小于下界，不然就返回错，然后继续判断它的左子树和右子树。
        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null)
                return true;
            int val = node.val;
            if (lower != null && val <= lower)
                return false;
            if (upper != null && val >= upper)
                return false;

            if (!helper(node.right, val, upper))
                return false;
            if (!helper(node.left, lower, val))
                return false;
            return true;
        }

    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode node = TreeNode.createNode(new int[]{10,5,15,-1,-1,6,20});
        boolean validBST = solution.isValidBST(node);
        System.out.println(validBST);
    }
}
