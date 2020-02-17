package com.mical.linklist;

/**
 * 类 名 称：LeetCode234
 * 类 描 述：力扣网234题
 * 题 描 述：请判断一个链表是否为回文链表
 * 输 入：1->2->2->1
 * 输 出：true
 * 创建时间：2020/2/17 13:20
 * 创建人：Mical
 */
public class LeetCode234 {
    class Solution {
        //首先分割链表成两个，再反转后面的链表，再判断两个链表的每个值是否相等
        public boolean isPalindrome(ListNode head){
            if (head == null){
                return true;
            }
            //1、首先找到链表的中点
            ListNode left = head;
            ListNode right = head.next;
            while (right != null && right.next != null){
                left = left.next;
                right = right.next.next;
            }

            //2、进行链表分割的操作
            ListNode first = head;
            ListNode last = left.next;
            left.next = null;

            //3、翻转第二个链表last
            ListNode second = null;
            ListNode cur = last;
            while (cur != null){
                ListNode temp = cur.next;
                cur.next = second;
                second = cur;
                cur = temp;
            }

            //4、判断两个链表的值是否相等
            while (first != null && second != null){
                if (first.val != second.val){
                    return false;
                }
                first = first.next;
                second = second.next;
            }
            return true;
        }
    }
}
