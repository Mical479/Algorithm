package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode203
 * 类 描 述：力扣网203题
 * 题 描 述：删除链表中等于给定值val的所有节点
 * 输 入：1->2->6->3->4->5->6, val = 6
 * 输 出：1->2->3->4->5
 * 创建时间：2020/2/13 17:06
 * 创建人：Mical
 */
public class LeetCode203 {
    //方法一：遍历链表节点
    public ListNode removeElements(ListNode head, int val){
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode ery = preHead;
        while (ery.next != null){
            if (ery.next.val == val){
                ery.next = ery.next.next;
            }else {
                ery = ery.next;
            }
        }
        return preHead.next;
    }

    //方法二：使用递归
    public ListNode removeElements2(ListNode head, int val){
        if (head == null){
            return null;
        }
        ListNode res = removeElements2(head.next, val);
        if (head.val == val){
            return res;
        }else {
            head.next = res;
            return head;
        }
    }

    @Test
    public void test(){
        ListNode list = ListNode.createList(new int[]{2, 4, 2, 5, 3, 6});
        removeElements2(list, 2);
    }
}
