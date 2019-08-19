package easy;

import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 15:10
 * description : 返回两条链表的交叉节点。
 */
public class T160_IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = getLinkedListLength(headA), lengthB = getLinkedListLength(headB);
        int delta;
        ListNode p, q;
        if (lengthA > lengthB) {
            delta = lengthA - lengthB;
            p = headA;
            q = headB;
        } else {
            delta = lengthB - lengthA;
            p = headB;
            q = headA;
        }
        while (p != null && delta > 0) {
            p = p.next;
            delta--;
        }
        while (p != null && q != null) {
            if (p == q) return p;
            else {
                p = p.next;
                q = q.next;
            }
        }
        return null;
    }


    public static int getLinkedListLength(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
