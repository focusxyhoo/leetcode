package leetcode.hard;

import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-10
 * time        : 21:07
 * description : 以 k 个节点为一组，反转链表，不足 k 的链表剩余元素保持原样。
 */
public class T25_ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        ListNode result = reverseKGroup(head, 2);
//        T23_MergeKLists.printList(result);
        ListNode result1 = reverseKGroup(head, 5);
        T23_MergeKLists.printList(result1);

    }

    /**
     * 递归思想
     * 对原始链表有修改
     *
     * @param head 被修改的链表
     * @param k
     * @return 返回修改后的链表的第一个节点
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;
        int count = 0;
        // 找到第 k+1 个节点
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        // count != k 时，即链表 head 的长度小于 k
        // 而 count == k 时，以第 k+1 个节点为 head，继续递归找
        if (count == k) {
            cur = reverseKGroup(cur, k); // 此时 cur 记录的是链表尾端的第一个节点
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur; // 循环（翻转）结束后，cur 指向的是该段链表的第一个节点
        }
        return head;
    }
}
