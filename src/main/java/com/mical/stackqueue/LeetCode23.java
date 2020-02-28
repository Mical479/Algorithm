package com.mical.stackqueue;

import com.mical.linklist.ListNode;
import org.junit.Test;

/**
 * 类 名 称：LeetCode23
 * 题 名 称：合并K个排序链表
 * 题 描 述：合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 输 入：[1->4->5,1->3->4,2->6]
 * 输 出：1->1->2->3->4->4->5->6
 * 创建时间：2020/2/28 10:53
 * 创建人：Mical
 */
public class LeetCode23 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            boolean flag = false; //记录这个数组是否全为空
            int min = Integer.MAX_VALUE; //记录最小索引
            int minValue = Integer.MAX_VALUE; //记录最小值，通过这两个东西找到列表中头元素最小的索引
            for (int i = 0; i < lists.length; i++) {
               if (lists[i] == null)
                   continue;
               if (lists[i].val < minValue) {
                   flag = true;
                   minValue = lists[i].val;
                   min = i;
               }
            }
            //如果链表为空，直接返回空
            if (!flag)
                return null;
            //找到最小索引min，移除该位置的链表的头
            ListNode minNode = lists[min];
            lists[min] = minNode.next;
            minNode.next = mergeKLists(lists);
            return minNode;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode list = ListNode.createList(new int[]{1, 4, 5});
        ListNode list1 = ListNode.createList(new int[]{1, 3, 4});
        ListNode list2 = ListNode.createList(new int[]{2, 6});
        ListNode node = solution.mergeKLists(new ListNode[]{list, list1, list2});
        ListNode.printList(node);
    }
}
