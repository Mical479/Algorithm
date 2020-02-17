package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode61
 * 类 描 述：力扣网61题(19题）
 * 题 描 述：给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 输 入：1->2->3->4->5->NULL, k = 2
 * 输 出：4->5->1->2->3->NULL
 * 解 释：向右旋转 1 步: 5->1->2->3->4->NULL；向右旋转 2 步: 4->5->1->2->3->NULL
 * 创建时间：2020/2/17 12:02
 * 创建人：Mical
 */
public class LeetCode61 {
    class Solution{
        //思路跟19题差不多，先找到最后k个元素，然后将后面的链表全部移动到前面去
        //由于本题 k 可能比链表的长度还大，所以必须遍历得到链表的长度，所以本题就不用19题那种双链表去找到待删除的节点，而是用索引
        public ListNode rotateRight(ListNode head, int k){
            if (head == null){
                return null;
            }
            //当k大于链表的长度时，就需要用k对链表长度取余，所以需要得到链表的长度，
            // 这里之所以初始化length为1，是为了在遍历得到链表长度的同时，还能够让headP指向链表的末尾
            int length = 1;
            ListNode headP = head;
            while (headP.next != null){
                length ++;
                headP = headP.next;
            }
            k = k % length;
            //定义虚拟节点
            ListNode preHead = new ListNode(-1);
            preHead.next = head;

            //初始化first指针
            ListNode first = preHead;
            int count = 0;
            //进行遍历，找到待移动的节点的前一个节点
            while (count < length - k){
                first = first.next;
                count ++;
            }
            //此时，first指向待移动节点的前一个节点

            //将first.next移动到整个链表的最前面
            headP.next = preHead.next;
            preHead.next = first.next;
            first.next = null;

            return preHead.next;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        ListNode list = ListNode.createList(new int[]{1, 2, 3});
        ListNode node = solution.rotateRight(list, 4);
        ListNode.printList(node);
    }
}
