package leetcode.hard;

import structure.TreeNode;

public class T99_RecoverBinarySearchTree {

    public static void recoverTree(TreeNode root) {
        if (root == null) return;
    }

    private static void swapTreeNode(TreeNode p, TreeNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }

    public static void main(String[] args) {

    }
}
