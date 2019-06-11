package medium;

import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 14:45
 * description : 链表的 partition。
 */
public class T86_PartitionList {
    /**
     * 重新组织两条链表，分别是前半部分和后半部分
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode h1 = null, t1 = null, h2 = null, t2 = null;
        while (head != null) {
            if (head.val < x) {
                if (t1 != null) {
                    t1.next = head;
                    t1 = t1.next;
                } else {
                    h1 = t1 = head;
                }
            } else {
                if (t2 != null) {
                    t2.next = head;
                    t2 = t2.next;
                } else {
                    h2 = t2 = head;
                }
            }
            head = head.next;
        }
        if (t2 != null) {
            t2.next = null;
        }
        if (t1 != null) {
            t1.next = h2;
        }
        return h1 != null ? h1 : h2;
    }
}
