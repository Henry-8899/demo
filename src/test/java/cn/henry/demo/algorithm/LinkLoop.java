package cn.henry.demo.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 */
public class LinkLoop {

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
     * 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。
     * 如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。
     * 如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
     *
     * 时间复杂度：O(n)，对于含有 n 个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1) 的时间。
     *
     * 空间复杂度：O(n)，空间取决于添加到哈希表中的元素数目，最多可以添加 n 个元素。
     *
     * @param node
     * @return
     */
    public boolean isLoop(Node node) {
        Set<Node> nodesSeen = new HashSet<>();
        while (node != null) {
            if (nodesSeen.contains(node)) {
                return true;
            } else {
                nodesSeen.add(node);
            }
            node = node.next;
        }
        return false;
    }
}
