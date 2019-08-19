package leetcode.hard;

import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-10
 * time        : 20:10
 * description : Merge K sorted linked lists and return it as one sorted list.
 */
public class T23_MergeKLists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        lists[0] = list1;
        printList(list1);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        lists[1] = list2;
        printList(list2);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        lists[2] = list3;
        printList(list3);
        ListNode result = mergeKLists(lists);
        printList(result);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = mergeTwoLists(lists[i], result);
            printList(result);
        }
        return result;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode p = list1, q = list2;
        ListNode result;

        if (p.val < q.val) {
            result = p;
            p = p.next;
        } else {
            result = q;
            q = q.next;
        }
        ListNode r = result;

        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }
        return result;
    }

    public static void printList(ListNode node) {
        ListNode p = node;
        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }
        System.out.println();
    }
}
