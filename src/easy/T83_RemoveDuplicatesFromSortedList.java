package easy;

import structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 17:00
 * description : 删除有序链表中的重复元素（保留一个）。
 * 一种简单的方法是用一个 set 集合来储存链表中的元素。当往 set 中添加失败时，删除该元素。
 */
public class T83_RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {

        Set<Integer> set = new HashSet<>();
        ListNode cur = head, prev = null;
        while (cur != null) {
            if (set.add(cur.val)) {
                prev = cur;
                cur = cur.next;
            } else {
                prev.next = cur.next;
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else
                cur = cur.next;
        }
        return head;
    }
}
