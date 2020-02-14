package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode82
 * 类 描 述：力扣网82题
 * 题 描 述：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 输 入：1->2->3->3->4->4->5
 * 输 出：1->2->5
 * 创建时间：2020/2/13 18:12
 * 创建人：Mical
 */
public class LeetCode82 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head){
            if (head == null){
                return null;
            }
            //设置虚拟头结点
            ListNode preHead = new ListNode(-1);
            preHead.next = head;
            //初始化两个指针，第一个指向虚拟头结点，第二个指向头节点
            ListNode first = preHead;
            ListNode second = preHead.next;
            //标识是否存在重复元素
            int count = 0;
            while (second.next != null){
                //如果第二个指针的值和第一个值一样，只用移动第二个指针即可
                if (first.next.val == second.next.val){
                    count = 1;
                    second = second.next;
                    continue;
                }
                //当count为1，表示需要删除节点
                if (count == 1){
                    //删除节点
                    first.next = second.next;
                    //重置标识位
                    count = 0;
                    second = second.next; //移动第二个指针
                    continue;
                }
                //当两个指针的值不一样，就正常移动指针
                first = first.next;
                second = second.next;
            }

            //上面结束循环时 second.next，所以当最后两个数相同时，已经结束循环了，所以还要再判断一次
            if (count == 1){
                first.next = second.next;
            }

            return preHead.next;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        ListNode list = ListNode.createList(new int[]{1, 1, 2, 3, 3, 3, 4, 5, 5});
        ListNode res = solution.deleteDuplicates(list);
        ListNode.printList(res);
    }
}
