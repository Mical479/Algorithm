package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode83
 * 类 描 述：力扣网83题
 * 题 描 述：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 输 入：1 -> 1 -> 2
 * 输 出：1 -> 2
 * 创建时间：2020/2/12 10:13
 * 创建人：Mical
 */
public class LeetCode83 {

    class Solution {
        //利用双指针技术，第一个指针指向没有重复的，第二个指针向前移动至重复后面的值
        public ListNode deleteDuplicates(ListNode head){
            //当head为空时，直接返回空
            if (head == null){
                return null;
            }
            ListNode pre = head;
            ListNode last = head.next;

            while (last != null){
                if (last.val == pre.val){
                    last = last.next;
                }else {
                    pre.next = last;
                    pre = pre.next;
                    last = last.next;
                }
            }
            //当链表最后两个值为重复值时，上面的循环不能去重，固应该将pre的next指针指向空
            pre.next = last;
            return head;
        }

        //此方法思路差不多，但代码更简洁
        public ListNode deleteDuplicates2(ListNode head){
            ListNode cur = head;
            while(cur != null && cur.next != null) {
                if(cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        ListNode head = ListNode.createList(new int[]{1, 1, 2});
        solution.deleteDuplicates(head);
        ListNode.printList(head);
    }
}
