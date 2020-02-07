package com.mical.linklist;

/**
 * 类 名 称：LeetCode206
 * 类 描 述：力扣网206题（92题）
 * 题 描 述：反转一个单链表
 * 输 入： 1->2->3->4->5->NULL
 * 输 出：5->4->3->2->1->NULL
 * 创建时间：2020/2/7 10:42
 * 创建人：Mical
 */
public class LeetCode206 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        //初始化时，pre指向null，cur指向head，next指向cur.next
        //要反转链表，则要先将 cur 指向pre，在依次将pre和cur和next向后移一个
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
