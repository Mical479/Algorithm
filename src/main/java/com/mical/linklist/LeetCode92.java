package com.mical.linklist;

import org.junit.Test;

/**
 * 类 名 称：LeetCode92
 * 类 描 述：力扣网92（206题）
 * 题 描 述：反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说 明：1 <= m <= n <= 链表长度
 * 输 入：1->2->3->4->5->NULL, m = 2, n = 4
 * 输 出：1->4->3->2->5->NULL
 * 创建时间：2020/2/7 10:55
 * 创建人：Mical
 */
public class LeetCode92 {

    public static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            int curIndex = 0;
            //初始化待反转节点的前一个节点，为head前面一个节点，让它的next指向head
            //之所以这样，是为了在m为1时，即头节点也反转时，也能够记录带反转节点的前一个节点
            ListNode preList = new ListNode(-1);
            preList.next = head;
            //查找待反转节点的前一个节点,curIndex指向m前一个节点，即 curIndex = m - 1，preList为m前一个节点名
            while (curIndex < m - 1) {
                preList = preList.next;
                curIndex++;
            }
            //初始化节点,pre指向待反转节点的第一个节点
            ListNode pre = preList.next;
            ListNode cur = pre.next;  //cur指向待反转节点的第二个节点
            curIndex += 2; //让curIndex为cur的索引
            //开始反转节点
            while (curIndex < n + 1){
                ListNode next = cur.next;  //先让next指向cur的下一个节点
                cur.next = pre;  //再让cur指向它前一个节点
                pre = cur;  //pre移动至cur
                cur = next; //cur移动至next
                curIndex ++; //移动索引
            }
            //此时curIndex索引指向待反转节点的后面一个节点,cur也是一样
            //pre则指向反转节点的最后一个节点
            preList.next.next = cur; //让反转节点的第一个节点的next指向cur
            preList.next = pre; //让反转节点前一个节点的next指向pre
            //如果m为1，说明头指针也被反转了，就不能反回头，直接返回反转节点的第一个节点
            if (m == 1){
                return preList.next;
            }
            return head;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        ListNode node = createList(new int[]{3, 5});
        ListNode listNode = solution.reverseBetween(node, 1, 2);
       printList(listNode);
    }
}
