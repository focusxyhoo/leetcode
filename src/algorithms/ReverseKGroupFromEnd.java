package algorithms;

import leetcode.easy.T206_ReverseLinkedList;
import leetcode.hard.T25_ReverseNodesInKGroup;
import structure.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-12
 * time        : 13:46
 * description : 从单链表尾节点开始以 K 为一组翻转链表。
 */
public class ReverseKGroupFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

//        printListNode(core1(head, 6));
        printListNode(core2(head, 4));

    }

    /**
     * 三遍遍历
     * @param head
     * @param k
     * @return
     */
    public static ListNode core1(ListNode head, int k) {
        head = T206_ReverseLinkedList.reverseList(head);
        head = T25_ReverseNodesInKGroup.reverseKGroup(head, k);
        return T206_ReverseLinkedList.reverseList(head);
    }

    public static void printListNode(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode core2(ListNode head, int k) {
        int listLen = len(head);
        int left = listLen % k;
        if (left == 0) return T25_ReverseNodesInKGroup.reverseKGroup(head, k);
        ListNode curr = head;
        while (left > 1) {
            curr = curr.next;
            left--;
        }
        ListNode temp = T25_ReverseNodesInKGroup.reverseKGroup(curr.next, k);
        curr.next = temp;
        return head;
    }

    private static int len(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
