package cn.henry.demo.algorithm.linkedlist;

/**
 * 删除链表的倒数第N个节点。 leetcode 19
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 */
public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度：O(L)，该算法对列表进行了两次遍历，首先计算了列表的长度 L 其次找到第 (L - n) 个结点。 操作执行了 2L-n 步，时间复杂度为 O(L)。
     *
     * 空间复杂度：O(1)，我们只用了常量级的额外空间。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;

        //为了获得head链表长度 length
        while (first != null) {
            length++;
            first = first.next;
        }

        //为了获得要删除的倒数第n个节点，的前一个节点的索引位置 length
        length -= n;
        first = dummy;

        //为了获得要删除的倒数第n个节点，的前一个节点
        while (length > 0) {
            length--;
            first = first.next;
        }

        //替换下一个节点
        first.next = first.next.next;
        return dummy.next;
    }


}
