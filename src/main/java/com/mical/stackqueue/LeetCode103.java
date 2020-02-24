package com.mical.stackqueue;

import org.junit.Test;
import sun.misc.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类 名 称：LeetCode103（102题，107题）
 * 题 描 述：给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 输 入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输 出：[[3],[20,9], [15,7]]
 * 创建时间：2020/2/24 8:48
 * 创建人：Mical
 */
public class LeetCode103 {

    class Solution {
        //思路一：整体思路跟前面两题一样，只是添加了一个标识位
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            //标识位，通过它判断列表的插入位置
            boolean order = false;
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> integers = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    if (order) {
                        integers.addFirst(treeNode.val);
                    } else {
                        integers.add(treeNode.val);
                    }
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                order = !order;
                lists.add(integers);
            }
            return lists;
        }

        public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            zigzagLevelHelper(lists, root, 0, false);
            return lists;
        }

        public void zigzagLevelHelper(List<List<Integer>> lists, TreeNode node, int level, boolean ziazag){
            if (node == null){
                return;
            }

            if (level == lists.size()){
                lists.add(new LinkedList<Integer>());
            }

            if (ziazag) {
                LinkedList<Integer> integers = (LinkedList<Integer>) lists.get(level);
                integers.addFirst(node.val);
            } else {
                lists.get(level).add(node.val);
            }
            zigzagLevelHelper(lists, node.left, level + 1, !ziazag);
            zigzagLevelHelper(lists, node.right, level + 1, !ziazag);
        }
    }

    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Solution solution = new Solution();
        solution.zigzagLevelOrder(treeNode);
    }
}
