package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode143
 * 类 描 述：力扣网143题
 * 题 描 述：给定一个单链表 L：L0→L1→…→Ln-1→Ln ，将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输 入：1->2->3->4
 * 输 出：1->4->2->3
 * 1 2 3 4 5 6 7 8 9 10
 * 1 10 2 9 3 8 4 7 5 6
 * 创建时间：2020/2/17 12:35
 * 创建人：Mical
 */
public class LeetCode143 {
    class Solution {
        //找到链表中间的节点，将链表分为两个链表，再将后面的链表翻转一次，最后合并两个链表即可
        public void reorderList(ListNode head){
            if (head == null)
                return;
            //1、找到链表中间节点，如果是偶数节点，循环后指向中间节点的前一个节点，如果是偶数节点，循环后就指向正中间节点
            ListNode left = head;
            ListNode right = head.next;
            while (right != null && right.next != null){
                left = left.next;
                right = right.next.next;
            }

            //2、将链表分割为前后两个链表
            ListNode first = head;
            ListNode second = left.next;
            left.next = null;

            //3、翻转第二个节点
            ListNode pre = null; //翻转后的头节点
            ListNode cur = second;
            while (cur != null){
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }

            //4、合并两个链表:pre和first
            ListNode preHead = new ListNode(-1);
            second = preHead;  //重复利用second
            while (first != null || pre != null) {
                second.next = first;
                first = first.next;
                second.next.next = pre;
                second = pre;
                //当整个链表的节点为奇数时，后面的链表会比前面的链表少一个节点名，所以这里后面的节点pre要进行判断
                pre = pre == null ? null : pre.next;
            }
            //5、修改head的指向
            head = preHead.next;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        ListNode list = ListNode.createList(new int[]{1, 2, 3, 4});
        solution.reorderList(list);
    }
}
