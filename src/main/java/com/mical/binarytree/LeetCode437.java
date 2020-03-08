package com.mical.binarytree;

import com.mical.stackqueue.TreeNode;

/**
 * 类 名 称：LeetCode437
 * 题 名 称：路径总和
 * 题 描 述：给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 输 入：
 * root: 10    sum: 8
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * 输 出：3
 * 解 释： 5 -> 3   5 -> 2 -> 1   -3 -> 11
 * 创建时间：2020/3/2 10:18
 * 创建人：Mical
 */
public class LeetCode437 {
    class Solution {
        //在以root为根节点的二叉树中，寻找和为sum的路径，返回这样的路径的个数
        public int pathSum(TreeNode root, int sum) {
            if (root == null)
                return 0;

            int res = findPath(root, sum);
            res += pathSum(root.left, sum);
            res += pathSum(root.right, sum);

            return res;
        }

        //在以node为根节点的二叉树中，寻找包含node的路径，和为sum
        //返回这样的路径个数
        public int findPath(TreeNode node, int num) {
            if (node == null)
                return 0;
            int res = 0;
            if (node.val == num)
                res += 1;
            //有可能继续往下加，还可以等于num
            res += findPath(node.left, num - node.val);
            res += findPath(node.right, num - node.val);
            return res;
        }

        //解法二：利用数组存入所有节点的值，然后从尾依次往前加，
        // 重点是p这个指针，它会指向当前数组中的尾巴，也是当前的遍历到的最后节点。
        // 重点是当遍历过同一层的左节点后遍历右节点，p的指向是一样的，它就是覆盖左节点的值。
        // 所以一个数组中就不会存在分叉的路径，即数组中组成的数永远都是一个路径。
        public int pathSum2(TreeNode root, int sum) {
            return pathSum(root, sum, new int[1000], 0);
        }

        public int pathSum(TreeNode root, int sum, int[] array/*保存路径*/, int p/*指向路径终点*/) {
            if (root == null) {
                return 0;
            }
            int tmp = root.val;
            int n = root.val == sum ? 1 : 0;
            for (int i = p - 1; i >= 0; i--) {
                tmp += array[i];
                if (tmp == sum) {
                    n++;
                }
            }
            array[p] = root.val;
            int n1 = pathSum(root.left, sum, array, p + 1);
            int n2 = pathSum(root.right, sum, array, p + 1);
            return n + n1 + n2;
        }
    }
}
