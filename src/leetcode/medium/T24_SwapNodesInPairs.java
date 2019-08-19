package leetcode.medium;

import structure.ListNode;

/**
 * @author focusxyhoo
 * @date 2019-05-04 11:17
 */
public class T24_SwapNodesInPairs {
    // recursion, faster but space
    public static ListNode swapPairsRecursively(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairsRecursively(head.next.next);
        n.next = head;
        return n;
    }

    // Non-Recursively, 注意分析清楚整个过程中的每一个细节，确保不会出错
    public static ListNode swapPairsWithoutRecursively(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode newHead = head.next, a = head, b = head.next, pre = null;
        while (a != null && b != null) {
            a.next = b.next;
            b.next = a;
            // 记录本次交换过程中的上一个节点，使其连接上正确的位置
            if (pre != null) {
                pre.next = b;
            }
            if (a.next == null) break;
            b = a.next.next;
            pre = a;
            a = a.next;
        }
        return newHead;
    }

    public static void printNodes(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.println("\n--------------------------");
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        ListNode result = swapPairsRecursively(root);
        printNodes(result);
//        cannot run together
//        ListNode res = swapPairsWithoutRecursively(root);
//        printNodes(res);

    }
}
