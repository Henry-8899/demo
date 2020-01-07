package cn.henry.demo.algorithm.linkedlist;

/**
 * 两两交换链表中的节点 leetcode 24
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            //交换位置
            ListNode l3 = l2.next;
            l1.next = l3;
            l2.next = l1;
            pre.next = l2;

            //重新赋值当前节点
            pre = l1;
        }
        return node.next;
    }
}
