package leetcode.easy;

import com.sun.source.tree.Tree;
import structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/7
 * time        : 20:39
 * description : https://leetcode.com/problems/symmetric-tree/
 */
public class T101_SymmetricTree {

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
    // Memory Usage: 37.3 MB, less than 74.15% of Java online submissions for Symmetric Tree.
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    // recursively + dfs
    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if ((left == null && right != null) || (left != null && right == null)) return false;
        if (left.val != right.val) return false;
        if (!dfs(left.left, right.right)) return false;
        if (!dfs(left.right, right.left)) return false;
        return true;
    }

    public boolean isSymmetricIteratively(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.poll();
            if (curr != null) {
                stack.push(curr.left);
                stack.push(curr.right);
            }
        }
        return true;
    }
}
