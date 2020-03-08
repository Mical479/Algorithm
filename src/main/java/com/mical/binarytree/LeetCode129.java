package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 名 称：LeetCode129
 * 题 名 称：求根到叶子节点数字之和
 * 题 描 述：给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 输 入： 4 9 0 5 1
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * 输 出：1026
 * 解 释： 495 + 491 + 40 = 1026
 * 创建时间：2020/3/1 17:07
 * 创建人：Mical
 */
public class LeetCode129 {
    class Solution {
        //蠢逼递归：将所有路径转成字符串求出，在对字符串列表进行求和
        public int sumNumbers(TreeNode root) {
            if (root == null)
                return 0;
            List<String> strings = sumHelper(root);
            int sum = strings.stream().mapToInt(Integer::parseInt).sum();
            return sum;
        }

        public List<String> sumHelper(TreeNode root) {
            ArrayList<String> list = new ArrayList<>();
            if (root == null)
                return list;
            if (root.left == null && root.right == null) {
                list.add(String.valueOf(root.val));
                return list;
            }

            List<String> strings = sumHelper(root.left);
            strings.forEach(item -> {
                list.add(root.val + item);
            });
            List<String> strings1 = sumHelper(root.right);
            strings1.forEach(item -> {
                list.add(root.val + item);
            });
            return list;
        }

        //解法二：定义一个全局变量，记录总和，传递的参数表示每条路径的总和
        int ans = 0;
        public int sumNumbers2(TreeNode root) {
            if (root == null)
                return 0;
            helper(root, 0);
            return ans;
        }

        public void helper(TreeNode node, int sum) {
            sum = sum * 10 + node.val;
            if (node.left == null && node.right == null)
                ans = sum + ans;
            if (node.left != null) {
                helper(node.left, sum);
            }
            if (node.right != null)
                helper(node.right, sum);
        }

        //解法三：利用参数和返回值，返回值表示每条路径的总和，参数表示所有树节点的总和
        public int sumNumbers3(TreeNode root) {
            return helper3(root, 0);
        }

        public int helper3(TreeNode node, int sum) {
            if (node == null)
                return sum;
            if (node.left == null && node.right == null)
                return sum * 10 + node.val;
            int left = 0, right = 0;
            if (node.left != null) {
                left = helper3(node.left, sum * 10 + node.val);
            }
            if (node.right != null)
                right = helper3(node.right, sum * 10 + node.val);
            return left + right;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
//        TreeNode treeNode = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int i = solution.sumNumbers2(treeNode);
        System.out.println(i);
    }
}
