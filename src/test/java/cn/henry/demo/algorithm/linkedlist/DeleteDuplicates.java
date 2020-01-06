package cn.henry.demo.algorithm.linkedlist;

/**
 * 删除排序链表中的重复元素 leetcode 83
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {

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
     * 时间复杂度：O(n)，因为列表中的每个结点都检查一次以确定它是否重复，所以总运行时间为 O(n)，其中 n 是列表中的结点数。
     *
     * 空间复杂度：O(1)，没有使用额外的空间。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        //特别注意：给定的是一个排序链表；已经排好顺序了；不会存在：1->2->3->4->5->1这种情况；
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
