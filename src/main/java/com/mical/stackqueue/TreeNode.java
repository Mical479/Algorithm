package com.mical.stackqueue;

/**
 * 类 名 称：TreeNode
 * 类 描 述：二叉树节点
 * 创建时间：2020/2/21 12:05
 * 创建人：Mical
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode (int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createNode(int[] arr){
        return createNode(arr, 0);
    }

    private static TreeNode createNode(int[] arr, int index){
        if (index >= arr.length || arr[index] == -1)
            return null;
        TreeNode treeNode = new TreeNode(arr[index]);
        treeNode.left = createNode(arr, 2 * index + 1);
        treeNode.right = createNode(arr, 2 * index + 2);
        return treeNode;
    }
}
