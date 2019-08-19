package leetcode.medium;

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
            if (cur.val == cur.next.val) { // 当前节点与下一个节点相同
                cur = cur.next; // 跳过下一节点
                while (cur.next != null && cur.next.val == cur.val) { // 跳过后续的所有相同的节点
                    cur = cur.next;
                }
                // 现在 cur 指最后一个相同的节点
                if (prev != null) { // 当 prev 不为空，跳过中间的所有相同元素
                    prev.next = cur.next;
                    cur = cur.next;
                } else { // prev = null，即链表一开始就有重复元素，此时 prev 不需要改变，而 head 需要被修改
                    head = cur.next;
                    cur = head;
                }
            } else { // 当前节点与下一节点不相同
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
