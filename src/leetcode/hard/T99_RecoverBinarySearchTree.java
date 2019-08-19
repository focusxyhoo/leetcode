package leetcode.hard;

import structure.TreeNode;

public class T99_RecoverBinarySearchTree {

    public static void recoverTree(TreeNode<Integer> root) {
        if (root == null) return;
    }

    private static void swapTreeNode(TreeNode<Integer> p, TreeNode<Integer> q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }

    public static void main(String[] args) {

    }
}
