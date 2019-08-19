package medium;

import hard.T23_MergeKLists;
import structure.ListNode;
import structure.RandomNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 13:45
 * description :
 */
public class T138_CopyListWithRandomPointer {

    public static void main(String[] args) {
        RandomNode head = new RandomNode(1);
        head.next = new RandomNode(2);
        head.next.next = new RandomNode(3);
        head.next.next.next = new RandomNode(4);
        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head.next;
        head.next.next.next.random = head.next.next;

        printRandomNodes(copyRandomList(head));
    }

    public static RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;
        RandomNode cur = head;
        // 将链表中的每个节点都复制一遍，置于其后，这里不要管 random 字段的复制
        while (cur != null) {
            RandomNode copy = new RandomNode(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // 从头再扫一遍，将 random 的值确定
        RandomNode prev = head;
        cur = head.next;
        while (cur != null && cur.next != null) {
            if (prev.random != null) {
                cur.random = prev.random.next;
            }
            prev = cur.next;
            cur = prev.next;
        }
        if (prev.random != null) {
            cur.random = prev.random.next;
        }

        // 断开新旧两条链表
        prev = head;
        cur = head.next;
        RandomNode result = cur;
        while (cur.next != null) {
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = null;
        return result;
    }

    public static void printRandomNodes(RandomNode head) {
        RandomNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + ": " + cur.random.val + ", ");
            cur = cur.next;
        }
    }
}
