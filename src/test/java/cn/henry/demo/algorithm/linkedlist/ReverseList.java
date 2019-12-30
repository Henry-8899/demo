package cn.henry.demo.algorithm.linkedlist;

/**
 * 反转链表 leetcode 206
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {

    public static class ListNode {
        private Object data;
        public ListNode next;

        public ListNode(Object data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public ListNode(Object data) {
            this.data = data;
        }
    }


    /**
     * 时间复杂度：O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //交换位置
            ListNode nextTemp = curr.next;
            curr.next = prev;

            //为了下次循环
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
