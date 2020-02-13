package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode328
 * 类 描 述：力扣网328题（86题）
 * 题 描 述：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 输 入：1->2->3->4->5->NULL
 * 输 出：1->3->5->2->4->NULL
 * 创建时间：2020/2/12 14:08
 * 创建人：Mical
 */
public class LeetCode328 {

    class Solution {
        //声明两个指针，第一个指向移动元素待加入的位置，第二个去遍历寻找待移动的元素
        public ListNode oddEventList(ListNode head) {
            if (head == null){
                return null;
            }
            //初始化两个指针
            ListNode first = head;
            ListNode second = head;
            //记录索引
            int count = 1;
            while (second.next != null) {
                //偶数节点不需要移动，奇数节点需要向前移动
                if ((count + 1) % 2 == 1) {
                    ListNode temp = second.next;
                    second.next = temp.next;
                    temp.next = first.next;
                    first.next = temp;
                    first = temp;
                } else {
                    second = second.next;
                }
                count++;
            }
            return head;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode list = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = solution.oddEventList(list);
        ListNode.printList(listNode);
    }
}
