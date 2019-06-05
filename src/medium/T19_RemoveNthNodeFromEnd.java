package medium;

import structure.ListNode;

/**
 * @author focusxyhoo
 * @date 2019-04-17 14:07
 */
public class T19_RemoveNthNodeFromEnd {

    // 两次遍历
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // 记录链表的长度
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length = length - n - 1;
        first = head;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }

    // 一次遍历
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index = head;
        ListNode cur = head;
        ListNode pre = head;
        int count = 1;
        while (index.next != null) {
            index = index.next;
            count++;
            if (count > n) {
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = cur.next;
//        cur.next = null;
        return head;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode result = removeNthFromEnd(root, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}

