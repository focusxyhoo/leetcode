package leetcode.easy;

import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 11:43
 * description : 判断链表是否有环
 */
public class T141_LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = head;
        head.next.next.next = new ListNode(4);

        System.out.println(hasCycle(null));


    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) { // && 会短路下一表达式
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
