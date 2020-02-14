package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode25
 * 类 描 述：力扣网25题
 * 题 描 述：给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 输 入：1->2->3->4->5， 3
 * 输出：3->2->1->4->5
 * 创建时间：2020/2/14 16:38
 * 创建人：Mical
 */
public class LeetCode25 {

    class Solution{
        //解法1：基本沿用了24题的解法，只是在那之上封装了几个方法。
        public ListNode reverseKGroup(ListNode head, int k){
            //定义虚拟头结点
            ListNode preHead = new ListNode(-1);
            preHead.next = head;

            //定义分组翻转的前一个节点
            ListNode p = preHead;
            while (isKGroup(p, k)){
                //获取本组结尾的节点
                ListNode sub = subKGroup(p, k);
                //记录本组开始节点
                ListNode pre = p.next;
                //记录下组开始的节点
                ListNode next = sub.next;
                //翻转节点
                ListNode node = reverseK(pre, next, k);
                p.next = node;

                p = pre;
            }
            return preHead.next;
        }

        //判断链表p后面是否存在足够的节点进行分组
        public boolean isKGroup(ListNode p, int k){
            int i = 0;
            while (i < k){
                if (p.next == null){
                    return false;
                }
                p = p.next;
                i ++;
            }
            return true;
        }

        //定位节点到本组节点结尾的节点
        public ListNode subKGroup(ListNode p, int k){
            int i = 0;
            while (i < k){
                p = p.next;
                i++;
            }
            return p;
        }

        //翻转链表的前k个节点，nextK节点为下一组开始翻转的节点
        public ListNode reverseK(ListNode p, ListNode nextK, int k){
            ListNode pre = nextK;
            ListNode sec = p;
            int i = 0;
            while (i < k){
                ListNode next = sec.next;
                sec.next = pre;
                pre = sec;
                sec = next;
                i ++;
            }
            return pre;
        }

        //解法二：使用递归，我感觉比我的简单多了。关键是思路更简单。
        public ListNode reverseKGroup2(ListNode head, int k){
            if(head==null||k==1)return head;
            ListNode q=head;
            for(int i=1;i<k;i++){
                if(q.next==null)return head;
                q=q.next;
            }
            ListNode p=new ListNode(-1);
            p.next=head;
            head=p;p=p.next;
            for(int i=k;i>1;i--){
                q=p.next;
                p.next=q.next;
                q.next=head.next;
                head.next=q;
            }
            p.next=reverseKGroup(p.next,k);
            return head.next;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        ListNode list = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode node = solution.reverseKGroup(list, 3);
        ListNode.printList(node);
    }
}
