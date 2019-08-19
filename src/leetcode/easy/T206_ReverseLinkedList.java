package leetcode.easy;

import algorithms.ReverseKGroupFromEnd;
import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 17:27
 * description : 翻转单链表
 */
public class T206_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode curr = reverseList(head);
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}

