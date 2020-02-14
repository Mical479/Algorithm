package com.mical.linklist;

/**
 * 类 名 称：LeetCode21
 * 类 描 述：力扣网21题
 * 题 描 述：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输 入：1->2->4, 1->3->4
 * 输 出：1->1->2->3->4->4
 * 创建时间：2020/2/14 16:05
 * 创建人：Mical
 */
public class LeetCode21 {

    class Solution {
        //使用递归
        public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if(l1 == null) {
                return l2;
            }
            if(l2 == null) {
                return l1;
            }

            if(l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
