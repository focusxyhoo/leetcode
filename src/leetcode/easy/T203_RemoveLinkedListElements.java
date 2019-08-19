package easy;

import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 17:24
 * description : 删除链表中与 val 值相同的元素。
 */
public class T203_RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode cur = head, prev = null;

        while (cur != null) {
            if (cur.val != val) {
                prev = cur;
                cur = cur.next;
            } else {
                if (prev != null) {
                    prev.next = cur.next;
                    cur = cur.next;
                } else {
                    cur = cur.next;
                    head = cur;
                }
            }
        }
        return head;
    }
}
