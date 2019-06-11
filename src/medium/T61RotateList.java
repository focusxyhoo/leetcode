package medium;

import easy.T160_IntersectionOfTwoLinkedLists;
import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 15:29
 * description :
 */
public class T61RotateList {

    /**
     * created by focusyxhoo:
     * 首先得到链表的长度。接着根据 length 与 k 的大小来判断旋转后链表的第一个节点的位置。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        // 特殊情况
        if (k == 0) return head;
        if (head == null) return null;

        // 链表长度
        int length = T160_IntersectionOfTwoLinkedLists.getLinkedListLength(head);
        // 根据length与k的关系来确定n的大小
        int n;
        if (k < length)
            n = length - k;
        else {
            if (length % k == 0) return head;
            else
                n = length - (k % length);
        }

        // 链表第 n 个节点即是旋转后链表的第一个节点
        ListNode cur = head, prev = null;
        while (n > 0) {
            prev = cur;
            cur = cur.next;
            n--;
        }
        prev.next = null;
        ListNode h = cur; // 记录翻转后链表的第一个节点
        while (cur.next != null) {
            cur = cur.next; // 找到最后一个节点位置
        }
        cur.next = head; // 最后一个节点连上原始链表第一个节点
        return h;
    }

    /**
     * 这种方法思路就很清晰。
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) return head; // 特殊情况
        int count = 1;
        ListNode cur = head;
        for (; cur.next != null; cur = cur.next, count++) ; // 记录链表长度
        cur.next = head; // 将链表连成环
        k = count - (k % count);
        // 从当前位置继续向前走 k 步即是翻转后链表的第一个节点
        for (int i = 1; i <= k; cur = cur.next, i++) ;
        head = cur.next;
        cur.next = null;
        return head;
    }
}
