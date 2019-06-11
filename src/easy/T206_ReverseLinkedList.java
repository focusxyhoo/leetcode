package easy;

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
        return head;
    }
}

