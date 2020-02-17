package com.mical.linklist;

/**
 * 类 名 称：LeetCode237
 * 类 描 述：力扣网237
 * 题 描 述：请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 输 入：head = [4,5,1,9], node = 5
 * 输 出：[4,1,9]
 * 解 释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 创建时间：2020/2/17 11:05
 * 创建人：Mical
 */
public class LeetCode237 {
    class Solution {
        //由于找不到待删除节点的前一个节点，固可以用下一个节点覆盖住当前节点，然后转而将下一个节点删除
        public void deleteNode(ListNode node){
            if (node == null){
                return;
            }
            if (node.next == null){
                node = null;
                return;
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
