package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode86
 * 类 描 述：力扣网86题(328题）
 * 题 描 述：给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 输 入：1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
 * 输 出：1 -> 2 -> 2 -> 4 -> 3 -> 5
 * 创建时间：2020/2/12 10:44
 * 创建人：Mical
 */
public class LeetCode86 {

    class Solution{
        //利用双指针，第一个指针 pre 找到比x大的第一个值，第二个指针在 pre 后面找比 x 小的值，放在pre前面。
        public ListNode partition(ListNode head, int x){
            if (head == null ){
                return null;
            }
            //在链表的head之前声明一个虚拟头结点，因为头节点也有可能需要移动
            ListNode pre = new ListNode(-1);
            pre.next = head;
            //找到比 x 大的第一个值的前一个值
            while (pre.next != null && pre.next.val < x ){
                pre = pre.next;
            }
            //当pre为null，说明链表中的值都是小于x的，就不用移动了
            if (pre.next == null){
                return head;
            }

            //初始化第二个指针
            ListNode sec = pre;
            while (sec.next != null){
                if (sec.next.val < x){ //此时sec.next指向比x小的节点
                    ListNode temp = sec.next;
                    //修改其指向
                    sec.next = sec.next.next;
                    //将temp节点移动到前面
                    temp.next = pre.next;
                    //当pre指针的下一个指针为头指针时，证明头指针需要移动，直接将头指针的指向修改为移动到最前面的temp
                    if (pre.next == head){
                        head = temp;
                    }
                    pre.next = temp;
                    pre = temp;
                }else {
                    sec = sec.next;
                }
            }
            System.out.println(head.val);
            return head;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        ListNode head = ListNode.createList(new int[]{2, 1});
        ListNode partition = solution.partition(head, 2);
        ListNode.printList(partition);
    }
}
