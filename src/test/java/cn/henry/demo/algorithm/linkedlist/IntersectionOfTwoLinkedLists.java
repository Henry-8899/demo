package cn.henry.demo.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class IntersectionOfTwoLinkedLists {

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
     * 时间复杂度 : O(m+n)O(m+n)。
     * 空间复杂度 : O(m)O(m) 或 O(n)O(n)。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> headAList = new HashSet<>();
        while (headA != null) {
            headAList.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (headAList.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
