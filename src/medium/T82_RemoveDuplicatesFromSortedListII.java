package medium;

import structure.ListNode;


/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 16:51
 * description : 删除有序链表中重复的元素(删除所有该元素)。
 * 思路：两个指针，一个指向当前节点，一个指向前一个节点。
 * 每次判断当前节点与下一个节点的值是否相同？
 * 若相同，需要往下遍历，直到找到不相同的节点，
 * 然后根据 prev 节点是否为空来判断当前重复的节点是在链表头节点（需要特殊处理）还是其他部分，
 * 若不相同，往下遍历即可，注意修改 prev 节点的值。
 */
public class T82_RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head, prev = null;
        // 首先判断是否为空，这里包括了检查链表为空或只有一个节点的情况
        while (cur != null && cur.next != null) {

            if (cur.val == cur.next.val) {
                cur = cur.next;
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                if (prev != null) {
                    prev.next = cur.next;
                    cur = cur.next;
                } else {
                    head = cur.next;
                    cur = head;
                }
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
