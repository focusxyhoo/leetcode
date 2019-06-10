package hard;

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

    }

    /**
     * @param head 被修改的链表
     * @param k
     * @return 返回修改后的链表的第一个节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {

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
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
