package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode2
 * 类 描 述：力扣网2题（445题是本题升级版）
 * 题 描 述：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输 入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输 出：7 -> 0 -> 8
 * 解 释：342 + 465 = 807
 * 创建时间：2020/2/12 14:50
 * 创建人：Mical
 */
public class LeetCode2 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            //记录某位是否存在进位，不存在为0，存在为1
            int count = 0;
            //初始化头节点
            int headV = l1.val + l2.val;
            if (headV >= 10) {
                count = 1;
            }
            head.val = headV % 10;
            //初始化遍历节点
            ListNode list = head;
            l1 = l1.next;
            l2 = l2.next;
            //当l1和l2任意一个不为空的情况都要遍历下去
            while (l1 != null || l2 != null) {
                int temp = count;
                //当l1不为空，需要加l1
                if (l1 != null) {
                    temp = temp + l1.val;
                }
                //当l2不为空，需要加l2
                if (l2 != null) {
                    temp = temp + l2.val;
                }
                //给list的下一个赋值
                list.next = new ListNode(temp % 10);
                //通过判断temp的值，去判断本次是否要进位，下一次循环是否需要多加1
                if (temp >= 10) {
                    count = 1;
                } else {
                    count = 0;
                }
                //l1不为空，则遍历l1
                if (l1 != null) {
                    l1 = l1.next;
                }
                //l2不为空，则遍历l2
                if (l2 != null) {
                    l2 = l2.next;
                }
                list = list.next;
            }

            //最后一位加起来大于10应该多加一位
            if (count == 1) {
                list.next = new ListNode(1);
            }
            return head;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode l1 = ListNode.createList(new int[]{5});
        ListNode l2 = ListNode.createList(new int[]{5});
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        ListNode.printList(listNode);
    }
}
