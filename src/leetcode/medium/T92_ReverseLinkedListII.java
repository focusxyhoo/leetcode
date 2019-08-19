package leetcode.medium;

import hard.T23_MergeKLists;
import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 10:27
 * description : 翻转链表的一部分
 * 两种方法的时间复杂度都是 O(N)
 * 空间复杂度前者为 O(1)，后者在最坏情况下为 O(N)
 */
public class T92_ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(head, 1, 2);
        T23_MergeKLists.printList(result);
    }

    /**
     * 第一种方法比较容易想，就是翻转链表多了一些限制条件，先根据 m 的指可以找到需要翻转的第一个节点的位置
     * 而后根据 n 的值可以确定需要翻转部分的最后一个节点，
     * 最后只需要额外判空以及连接几段链表即可。
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // 记录下第 m-1 个和第 m 个节点
        // 当 m = 1 时，prev = null，cur = head
        ListNode con = prev, tail = cur;

        ListNode next = null; // 翻转时需要借助的指针
        while (n > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            n--;
        } // 循环结束后，翻转部分的第一个节点是 prev，cur 指向链表尾部没有变化的那段的第一个节点

        // 连接链表
        if (con != null) { // 判断第 m-1 个节点是否为空，分别有两种处理方法
            con.next = prev;
        } else
            head = prev;
        tail.next = cur;

        return head;
    }

    /**
     * 递归
     * 采用翻转数组的类似想法，只交换值，没有动链表结构
     *
     * @param right
     * @param m
     * @param n
     */
    public static void recurseAndReverse(ListNode right, int m, int n) {
        if (n == 1) { // 当 n = 1 时，right 到达其目的地，后面的节点不需要处理
            return;
        }
        right = right.next;
        if (m > 1) { // 当 m = 1 时，left 到达其目的地
            left = left.next;
        }
        recurseAndReverse(right, m - 1, n - 1);

        if (left == right || right.next == left) { // 判断 left 和 right 是否相遇
            stop = true;
        }
        if (!stop) { // 当 left 和 right 没有相遇时，交换两个节点的值
            int t = left.val;
            left.val = right.val;
            right.val = t;

            left = left.next; // left 需要向前移动，而 right 不需要，因为 right 随递归在移动
        }
    }

    private static boolean stop; // 是否结束的标志位
    private static ListNode left; // 左边节点

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        left = head;
        stop = false;
        recurseAndReverse(head, m, n);
        return head;
    }
}
