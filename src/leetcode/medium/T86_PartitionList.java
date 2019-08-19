package medium;

import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 14:45
 * description : https://leetcode.com/problems/partition-list/
 */
public class T86_PartitionList {
    /**
     * 链表的 partition。
     * 给定单链表和一个值 x，要求链表中比 x 小的都在 大于等于 x 的元素前面。
     * 重新组织两条链表，分别是前半部分和后半部分
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode head1 = null, tail1 = null, head2 = null, tail2 = null;
        // 四个指针，分别是比 x 大、小的两段单链表的首尾节点
        while (head != null) {
            if (head.val < x) { // 当前节点比给定值小
                if (tail1 != null) {
                    tail1.next = head;
                    tail1 = tail1.next;
                } else {
                    head1 = tail1 = head;
                }
            } else { // 当前节点大于等于给定值
                if (tail2 != null) {
                    tail2.next = head;
                    tail2 = tail2.next;
                } else {
                    head2 = tail2 = head;
                }
            }
            head = head.next;
        }
        // 在遍历结束后，一定要判断两段链表的尾节点是否为空
        // 因为原链表中可能不存在小于（不小于）x 的节点
        // 尾节点为空，头节点也一定为空
        if (tail2 != null) {
            tail2.next = null;
        }
        if (tail1 != null) {
            tail1.next = head2;
        }
        return head1 != null ? head1 : head2;
    }
}
