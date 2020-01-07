package cn.henry.demo.algorithm.linkedlist;

import org.junit.Test;

/**
 * 请判断一个链表是否为回文链表。leetcode 234
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode o) {
            val = x;
            next = o;
        }
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(2,
                                        new ListNode(1,
                                                new ListNode(1,
                                                        new ListNode(3, null)))))));
        ListNode listNode2 = new ListNode(1,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(2,
                                        new ListNode(1,
                                                new ListNode(1,
                                                        new ListNode(3, null)))))));
        boolean palindrome = isPalindrome(listNode);
        boolean palindrome2 = isPalindrome2(listNode2);
        System.out.println(palindrome);
    }


    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 相对于下面那种多了层遍历
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //1、为了获得后半段链表slow
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //当head为奇数个，fast不为null;
        if (fast != null) {
            slow = slow.next;
        }

        //2、把得到的后半段链表 反转
        if (slow.next != null) {
            ListNode p = slow;
            ListNode pre;
            while (p.next != null) {
                pre = slow;
                slow = p.next;
                p.next = p.next.next;
                slow.next = pre;
            }
        }

        //3、反转后 逐一比较， 直到slow到达末尾处
        while (slow != null) {
            if (slow.val == head.val) {
                slow = slow.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 快慢指针 ---大牛解法
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //假设此时head：[1,1,2,2,1,1,3]
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;

        //边遍历边反转
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;

            //反转
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }

        //pre:[2,1,1]
        //slow:[1,1,3]
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
