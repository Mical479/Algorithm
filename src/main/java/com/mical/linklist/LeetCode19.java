package com.mical.linklist;

/**
 * 类 名 称：LeetCode19
 * 类 描 述：力扣网19题
 * 题 描 述：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 输 出： 1->2->3->4->5,  n = 2
 * 输 出：1->2->3->5.
 * 创建时间：2020/2/17 11:53
 * 创建人：Mical
 */
public class LeetCode19 {
    class Solution {
        //利用双指针技术，当一个指针指向 删除节点 的前一个节点，另外一个指针指向链表最后的空，则两个指针相差 n  + 1 位
        //我们只要初始化两个相差为n + 1未的指针，当后面的指针指向空，则前面指针就指向了删除节点前一个节点
        public ListNode removeNthFromEnd(ListNode head, int n){
            //虚拟头结点
            ListNode preHead = new ListNode(-1);
            preHead.next = head;

            //初识化两个指针
            ListNode first = preHead;
            ListNode second = preHead;
            for (int i = 0; i < n + 1; i++) {
                second = second.next;
            }

            //开始遍历
            while (second != null){
                first = first.next;
                second = second.next;
            }
            //遍历后，此时的first就指向了 删除节点的前一个节点
            //删除节点
            first.next = first.next.next;
            return preHead.next;
        }
    }
}
