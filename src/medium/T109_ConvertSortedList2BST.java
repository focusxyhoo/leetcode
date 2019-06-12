package medium;

import structure.ListNode;
import structure.TreeNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-12
 * time        : 10:38
 * description : 给出一个升序排序的单链表，将其转换为一个平衡的二叉搜索树。
 */
public class T109_ConvertSortedList2BST {

    public static TreeNode sortedList2BST(ListNode head) {

        ListNode cur = head.next;
        TreeNode root = new TreeNode(head.val);
        while (cur != null) {
            if (root.val > cur.val)
                ;
        }

        return null;
    }
}
