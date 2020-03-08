package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 类 名 称：LeetCode113
 * 题 名 称：路径总和
 * 题 描 述：给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 输 入：
 * treeNode:     5    sum: 22
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 输 出：[[5,4,11,2],[5,8,4,5]]
 * 创建时间：2020/3/1 15:28
 * 创建人：Mical
 */
public class LeetCode113 {
    class Solution {
        //解法一：利用参数传递关键数据
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> list = new ArrayList<>();
            sumHelper(root, sum, list, new ArrayList<>());
            return list;
        }

        public void sumHelper(TreeNode node, int sum, List<List<Integer>> list, List<Integer> subList) {
            if (node == null)
                return;
            if (node.left == null && node.right == null && node.val == sum) {
                subList.add(node.val);
                list.add(subList);
                return;
            }
            subList.add(node.val);
            sumHelper(node.left, sum - node.val, list, new ArrayList<>(subList));
            sumHelper(node.right, sum - node.val, list, new ArrayList<>(subList));
        }

        //解法二：利用返回的结果值
        public List<List<Integer>> pathSum2(TreeNode root, int sum) {
            List<List<Integer>> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            if (root.left == null && root.right == null && root.val == sum) {
                LinkedList<Integer> subList = new LinkedList<>();
                subList.add(root.val);
                list.add(subList);
                return list;
            }

            List<List<Integer>> leftList = pathSum2(root.left, sum - root.val);
            leftList.forEach(item -> {
                LinkedList<Integer> item1 = (LinkedList<Integer>) item;
                item1.addFirst(root.val);
                list.add(item1);
            });

            List<List<Integer>> rightList = pathSum2(root.right, sum - root.val);
            rightList.forEach(item -> {
                LinkedList<Integer> item1 = (LinkedList<Integer>) item;
                item1.addFirst(root.val);
                list.add(item1);
            });

            return list;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        List<List<Integer>> list = solution.pathSum2(treeNode, 8);
        System.out.println(list);
    }
}
