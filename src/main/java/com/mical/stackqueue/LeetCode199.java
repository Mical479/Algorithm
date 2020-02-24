package com.mical.stackqueue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 类 名 称：LeetCode199
 * 题 描 述：给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 输 入：
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *输 出：[1, 3, 4]
 * 创建时间：2020/2/24 9:42
 * 创建人：Mical
 */
public class LeetCode199 {

    class Solution {
        //思路：取没层层序遍历最右边的元素。
        public List<Integer> rightSideView(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            list.add(root.val);
            LinkedList<TreeNode> treeNodes = new LinkedList<>();
            treeNodes.add(root);
            while (!treeNodes.isEmpty()) {
                int size = treeNodes.size();
                list.add(treeNodes.getLast().val);

                for (int i = 0; i < size; i++) {
                    TreeNode node = treeNodes.poll();
                    if (node.left != null) {
                        treeNodes.offer(node.left);
                    }

                    if (node.right != null){
                        treeNodes.offer(node.right);
                    }
                }
            }

            return list;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.rightSideView(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4))));
    }
}
