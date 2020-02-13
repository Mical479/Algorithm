package com.mical.linklist;

import org.junit.Test;

import java.util.Stack;

/**
 * 类 名 称：LeetCode445
 * 类 描 述：力扣网445题（2题的升级版，相当于从链表的尾部开始加）
 * 题 描 述：给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *  * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 输 入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输 出：7 -> 8 -> 0 -> 7
 * 创建时间：2020/2/12 16:17
 * 创建人：Mical
 */
public class LeetCode445 {
    class Solution {
        /*****************方法一：行不通的方法********************************/
        //思路：第2题，是将两个数反过来成列表，所以可以每个节点按照常数一次相加，大于10就进1
        //此题：直接将两个链表转换成数字，数字相加后再直接转换成列表返回,此解法失败了，贼子LeetCode传入的node转化成数字连long都装不下
        //所以需要改进，计算时应该返回String，且不应该简单相加，应该将字符转为数字一个一个加
        public ListNode addTwoNumbers(ListNode l1, ListNode l2){
            //记录两个列表之和的数字
            long count = listToNumbers(l1) + listToNumbers(l2);
            //将数字转化为String，便于拆分成一个一个的
            String cString = count + "";
            //将数字转化为列表,此处减去0这个字符，是为了将实际的数字字符转为数字
            ListNode head = new ListNode(cString.charAt(0) - '0');
            ListNode list = head;
            for (int i = 1; i < cString.length(); i++) {
               list.next = new ListNode(cString.charAt(i) - '0');
               list = list.next;
            }
            return head;
        }

        public long listToNumbers(ListNode list){
            long temp = 0;
            while (list != null){
                temp = temp * 10 + list.val;
                list = list.next;
            }
            return temp;
        }

        /*************************方法二：使用栈*************************/
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
            Stack<Integer> stack1 = buildStack(l1);
            Stack<Integer> stack2 = buildStack(l2);

            //定义一个头结点
            ListNode head = new ListNode(-1);
            ListNode p = head;
            //定义个进位变量
            int carry = 0;
            //遍历两个栈的时候，依次出栈的数据相加，即代表从低位开始相加
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
                int x = stack1.isEmpty() ? 0 : stack1.pop();
                int y = stack2.isEmpty() ? 0 : stack2.pop();
                int sum = x + y + carry;
                ListNode node = new ListNode(sum % 10);
                //相当于把当前节点node插入到已有的链表中的头部
                //将7插入到已经构造好的链表的首部（head下一个节点）
                node.next = head.next;
                head.next = node;
                carry = sum / 10;
            }
            return head.next;
        }

        public Stack<Integer> buildStack(ListNode list){
            Stack<Integer> stack = new Stack<>();
            while (list != null){
                stack.push(list.val);
                list = list.next;
            }
            return stack;
        }
    }

    @Test
    public void test(){
//        Solution solution = new Solution();
//        ListNode list = ListNode.createList(new int[]{3,9,9,9,9,9,9,9,9,9});
//        ListNode list2 = ListNode.createList(new int[]{7});
//        ListNode listNode = solution.addTwoNumbers(list, list2);
//        ListNode.printList(listNode);
        System.out.println(Long.MAX_VALUE);
    }
}
