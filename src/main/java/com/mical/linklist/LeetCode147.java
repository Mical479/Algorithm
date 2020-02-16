package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode147
 * 类 描 述：力扣网147题
 * 题 描 述：对链表进行插入排序，使用迭代算法，每次迭代只移动一个元素，只从输入数据中移除一个待排序的元素，
 * 找到它在序列中适当的位置，并将其插入。
 * 输 入：-1->5->3->4->0
 * 输 出：-1->0->3->4->5
 * 创建时间：2020/2/16 10:19
 * 创建人：Mical
 */
public class LeetCode147 {
    class Solution {
        public ListNode insertionSortList(ListNode head){
            if (head == null || head.next == null){
                return head;
            }
            //创建虚拟头结点
            ListNode preHead = new ListNode(-1);
            preHead.next = head;

            ListNode cur = head;
            while (cur.next != null){
                //当找到后面的值比前面的小 时
                if (cur.next.val < cur.val){
                    ListNode temp = cur.next; //这是待插入的值
                    cur.next = temp.next; //将当前指针直接指向待移动元素的后面，此时temp元素相当于被移除了
                    //进行二次遍历，查找待插入的位置
                    ListNode pre = preHead; //二次遍历指针,遍历后指向的是插入位置的前面一个节点
                    while (pre.next.val <= temp.val){
                        pre = pre.next;
                    }
                    ListNode after = pre.next; //指向的是插入位置的后面面一个节点
                    //插入temp
                    temp.next = after;
                    pre.next = temp;
                } else {
                    cur = cur.next;
                }
            }
            return preHead.next;
        }
    }

    @Test
    public void test(){
        ListNode list = ListNode.createList(new int[]{4, 2, 1, 3});
        Solution solution = new Solution();
        ListNode node = solution.insertionSortList(list);
        ListNode.printList(node);
    }
}
