package com.mical.linklist;

/**
 * 类 名 称：LeetCode24
 * 类 描 述：力扣网24题
 * 题 描 述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输 入：1->2->3->4
 * 输 出：2->1->4->3
 * 创建时间：2020/2/14 16:31
 * 创建人：Mical
 */
public class LeetCode24 {

    class Solution{
        //初始化三个指针，带交换两个节点前面的节点，待交换的两个节点。
        public ListNode swapPairs(ListNode head){
            ListNode preHead = new ListNode(-1);
            preHead.next = head;

            ListNode p = preHead;
            while (p.next != null && p.next.next != null){
                //声明待交换的两个节点
                ListNode node1= p.next;
                ListNode node2 = node1.next;
                //进行节点的交换
                node1.next = node2.next;
                node2.next = node1;
                p.next = node2;
                //更新p节点
                p = node1;
            }
            return preHead.next;
        }
    }
}
