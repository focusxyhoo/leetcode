package leetcode.easy;

import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-12
 * time        : 10:06
 * description : 求链表的中间节点。
 * 如果链表元素是奇数个，返回中间节点，若是偶数个，返回后一个。
 */
public class T876_MiddleOfLinkedList {

    public static ListNode middleNode(ListNode head) {
//        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
