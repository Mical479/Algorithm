package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode230
 * 题 名 称：二叉搜索树中第k小的元素
 * 题 描 述：给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 输 入：
 *    3          k = 1
 *   / \
 *  1   4
 *   \
 *    2
 * 输 出：1
 * 创建时间：2020/3/8 10:29
 * 创建人：Mical
 */
public class LeetCode230 {
    //思路：按照搜索树的顺序，去遍历二叉树，并将二叉树的值插入数组或者列表。本题是进行中序遍历。
    class Solution {
        int index = 0;
        public int kthSmallest(TreeNode root, int k) {
            int[] arr = new int[k];
            inOrder(arr, root);
            return arr[k - 1];
        }

        public void inOrder(int[] arr, TreeNode node) {
            //这里判断 index 是因为如果已经找到第k小的可以提前结束循环
            if (node == null || index > arr.length - 1)
                return;
            inOrder(arr, node.left);
            //这里需要再判断一遍，是因为之前递归进去左边的函数如果已经填满数组，那么返回后，它还会执行赋值的操作，所以需要再判断一遍，让它直接返回。
            if (index > arr.length - 1){
                return;
            }
            arr[index ++] = node.val;
            inOrder(arr, node.right);
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createNode(new int[]{3, 1, 4, -1, 2});
        int i = solution.kthSmallest(root, 1);
        System.out.println(i);
    }
}
