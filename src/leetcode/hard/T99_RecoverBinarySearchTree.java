package leetcode.hard;

import structure.TreeNode;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-09-07
 * time        : 20:22
 * description : https://leetcode.com/problems/recover-binary-search-tree
 * BST 的中序遍历是是有序的，因此如果其中两个节点交换位置后，其有序性便不复存在，我们的目的就是找到这两个交换的节点。
 * 若当节点的值小于前一个节点，则记录下来这两个节点的位置，first = prev，second = root，
 * 后面继续查找，若仍有这种情况出现，仅更新 second = root 即可。
 */

public class T99_RecoverBinarySearchTree {

    // Runtime: 2 ms, faster than 99.95% of Java online submissions for Recover Binary Search Tree.
    // Memory Usage: 37.7 MB, less than 92.31% of Java online submissions for Recover Binary Search Tree.
    public static void recoverTree(TreeNode root) {
        dfs(root);
        swapTreeNode(firstPos, secondPos);
    }

    private static TreeNode firstPos = null;
    private static TreeNode secondPos = null;
    private static TreeNode prev = null;

    private static void dfs(TreeNode root) {
        // 递归基
        if (root == null) return;
        // 中序遍历左子树
        dfs(root.left);
        if (prev != null) {
            // 检查是否存在逆序的情况
            if (firstPos == null && prev.val > root.val) {
                firstPos = prev;
            }
            if (firstPos != null && prev.val > root.val) {
                secondPos = root;
            }
        }
        prev = root; // 更新 prev 的值
        // 中序遍历右子树
        dfs(root.right);
    }

    private static void swapTreeNode(TreeNode p, TreeNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}
