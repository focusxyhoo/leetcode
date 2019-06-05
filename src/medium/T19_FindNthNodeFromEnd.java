package medium;

import structure.ListNode;

/**
 * @author focusxyhoo
 * @date 2019-04-26 16:21
 */
public class T19_FindNthNodeFromEnd {

    public static int getListLength(ListNode head) {
        /**
         * 返回链表的长度。有头节点。
         */
        int count = 0;
        ListNode cur = head.next;
        if (cur == null) {
            return 0;
        } else {
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count;
        }
    }

    public static ListNode findNthNodeFromEnd(ListNode head, int k) {
        /**
         * 查找链表倒数第 k 个节点。
         */
        int len = getListLength(head);
        ListNode cur = head;
        if (k > len) {
            return null;
        }
        // 注意这里的条件，以及 i 和 cur 的关系。
        for (int i = 0; i < len - k + 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static ListNode findNthNodeRecursively(ListNode head, int k) {
        /**
         * 使用递归的方式遍历链表。
         */
        int num = k;
        if (head == null) {
            return null;
        }
        ListNode cur = findNthNodeRecursively(head.next, k);
        if (cur != null) {
            return cur;
        } else {
            num--;
            if (num == 0) {
                return head;
            }
            return null;
        }
    }

    public static ListNode findNthNodeOne(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                return null;
            }
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        System.out.println(getListLength(root));
        System.out.println(findNthNodeFromEnd(root, 1).val);
        System.out.println(findNthNodeOne(root, 1).val);
        System.out.println(findNthNodeRecursively(root, 1).val);

    }
}
