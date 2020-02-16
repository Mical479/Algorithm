package com.mical.linklist;

/**
 * 类 名 称：LeetCode148
 * 类 描 述：力扣网148题
 * 题 描 述：在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 输 入：4->2->1->3
 * 输 出：1->2->3->4
 * 创建时间：2020/2/16 11:15
 * 创建人：Mical
 */
public class LeetCode148 {
    class Solution {
        //递归排序：自顶向下进行递归
        public ListNode sortList(ListNode head){
            if (head == null || head.next == null){
                return head;
            }
            //寻找此链表的中点，快慢指针。快指针每次移动两步，慢指针每次移动一步，到最后慢指针就指向中点
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            //分割链表，将链表分成左右两部分
            ListNode temp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(temp);
            //将左右两部分链表合并
            ListNode pre = new ListNode(0);
            ListNode res = pre;
            while (left != null && right != null){
                if (left.val < right.val){
                    pre.next = left;
                    left = left.next;
                } else {
                    pre.next = right;
                    right = right.next;
                }
                pre = pre.next;
            }
            //当左右链表的节点个数不一样时
            pre.next = left != null ? left : right;
            return res.next;
        }

        //递归排序：非递归的方法，从底至顶直接合并
        public ListNode sortList2(ListNode head){
            ListNode h, h1, h2, pre, res;
            h = head;
            int length = 0, intv = 1;
            while (h != null) {
                h = h.next;
                length++;
            }
            res = new ListNode(0);
            res.next = head;
            while (intv < length) {
                pre = res;
                h = res.next;
                while (h != null) {
                    int i = intv;
                    h1 = h;
                    while (i > 0 && h != null) {
                        h = h.next;
                        i--;
                    }
                    if (i > 0) break;
                    i = intv;
                    h2 = h;
                    while (i > 0 && h != null) {
                        h = h.next;
                        i--;
                    }
                    int c1 = intv, c2 = intv - i;
                    while (c1 > 0 && c2 > 0) {
                        if (h1.val < h2.val) {
                            pre.next = h1;
                            h1 = h1.next;
                            c1--;
                        } else {
                            pre.next = h2;
                            h2 = h2.next;
                            c2--;
                        }
                        pre = pre.next;
                    }
                    pre.next = c1 == 0 ? h2 : h1;
                    while (c1 > 0 || c2 > 0) {
                        pre = pre.next;
                        c1--;
                        c2--;
                    }
                    pre.next = h;
                }
                intv *= 2;
            }
            return res.next;
        }
    }
}
