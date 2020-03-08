package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode108
 * 题 名 称：将有序数组转换成二叉搜索树
 * 题 描 述：将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 输 入：[-10,-3,0,5,9]
 * 输 出：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * 创建时间：2020/3/8 10:02
 * 创建人：Mical
 */
public class LeetCode108 {
    //有点像归并排序的样子。因为要创建二插搜索树，我们可以创建一颗标准的二分搜索树，
    // 所以每次递归以数组的中间节点为根节点，它的左节点在数组的左边中间节点继续递归，右节点在数组的右边中间节点继续递归。
    class Solution {
        int[] nums;
        public TreeNode sortedArrayToBST(int[] nums) {
            this.nums = nums;
            return helper(0, nums.length - 1);
        }

        public TreeNode helper(int left, int right) {
            if (left > right)
                return null;

            int p = (left + right) / 2;

            TreeNode treeNode = new TreeNode(nums[p]);
            treeNode.left = helper(left, p - 1);
            treeNode.right = helper(p + 1, right);
            return treeNode;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
