package cn.henry.demo.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class LinkedListCycle2 {


    public static class Node {
        private Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 时间复杂度：O(n)
     *
     * 不管是成环还是不成环的输入，算法肯定都只会访问每个节点一次。对于非成环列表这是显而易见的，因为第 n 个节点指向 null ，这会让循环退出。对于循环列表， if 条件满足时会导致函数的退出，因为它指向了某个已经访问过的节点。两种情况下，访问的节点数最多都是 nn 个，所以运行时间跟节点数目成线性关系。
     *
     * 空间复杂度：O(n)
     *
     * 不管成环或者不成欢的输入，我们都需要将每个节点插入 Set 中一次。两者唯一的区别是最后访问的节点后是 null 还是一个已经访问过的节点。因此，由于 Set 包含 nn 个不同的节点，所需空间与节点数目也是线性关系的。
     * @param head
     * @return
     */
    public Node detectCycle(Node head) {
        Set<Node> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return head;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
