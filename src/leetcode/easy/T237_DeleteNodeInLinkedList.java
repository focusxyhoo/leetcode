package easy;

import structure.ListNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-12
 * time        : 09:57
 * description : 删除单链表中的某个节点，但是只给出了这个节点，而不知道单链表的第一个节点。
 * 解决思路：用 node.next.val 覆盖掉 node.val，然后跳过 node.next 节点即可。
 * 注意事项：1。链表至少含有两个元素；
 * 2。node 节点不能是尾节点，且存在于链表中；
 * 3。链表节点元素都不相同。
 *
 */
public class T237_DeleteNodeInLinkedList {

    public static void deleteNode(ListNode node) {
        ListNode cur = node, next = node.next;
        cur.val = next.val;
        cur.next = next.next;
    }
}
