package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类 名 称：LeetCode257
 * 题 名 称：二叉树的所有路径
 * 题 描 述：给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 输 入：
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输 出：["1->2->5", "1->3"]
 * 创建时间：2020/3/1 14:57
 * 创建人：Mical
 */
public class LeetCode257 {
    class Solution {
        //解法一：充分利用递归函数的语意及其返回值。
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            if (root == null)
                return list;
            //如果root为光棍节点
            if (root.left == null && root.right == null) {
                list.add(String.valueOf(root.val));
                return list;
            }
            //获取左子树的所有路径
            List<String> leftS = binaryTreePaths(root.left);
            leftS.forEach(item -> {
                list.add(root.val + "->" + item);
            });
            //获取右子树的所有路径
            List<String> rightS = binaryTreePaths(root.right);
            rightS.forEach(item -> {
                list.add(root.val + "->" + item);
            });
            return list;
        }
        //解法二：充分利用递归函数中的参数，利用参数将重要信息一步一步传下去。
        public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
            if (root != null) {
                path += Integer.toString(root.val);
                if ((root.left == null) && (root.right == null))  // 当前节点是叶子节点
                    paths.add(path);  // 把路径加入到答案中
                else {
                    path += "->";  // 当前节点不是叶子节点，继续递归遍历
                    construct_paths(root.left, path, paths);
                    construct_paths(root.right, path, paths);
                }
            }
        }

        public List<String> binaryTreePaths2(TreeNode root) {
            LinkedList<String> paths = new LinkedList();
            construct_paths(root, "", paths);
            return paths;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        List<String> strings = solution.binaryTreePaths2(treeNode);
        System.out.println(strings);
    }
}
