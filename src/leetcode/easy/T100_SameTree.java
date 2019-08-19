package easy;

import structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class T100_SameTree {

    /**
     * 递归写法。
     * 在与树相关的算法实现中，递归的写法总是最简单的。
     * Runtime: 2 ms
     * Memory Usage: 36.7 MB
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTreeRecursively(TreeNode p, TreeNode q) {
        // 判空必不可少
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        // 首先比较根节点是否相同
        if (p.val != q.val) return false;
        // 然后递归判断左子树与右子树。
        return isSameTreeRecursively(p.left, q.left) && isSameTreeRecursively(p.right, q.right);
    }

    /**
     * Runtime: 1 ms, faster than 5.38% of Java online submissions for Same Tree.
     * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Same Tree.
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTreeIteratively(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        Deque<TreeNode> stackP = new LinkedList<>();
        Deque<TreeNode> stackQ = new LinkedList<>();
        stackP.push(p);
        stackQ.push(q);
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode tempP = stackP.pop();
            TreeNode tempQ = stackQ.pop();
            if (tempP.val != tempQ.val) return false;
            if (tempP.left != null && tempQ.left != null) {
                stackP.push(tempP.left);
                stackQ.push(tempQ.left);
            } else if (tempP.left == null && tempQ.left == null) {
            } else return false;
            if (tempP.right != null && tempQ.right != null) {
                stackP.push(tempP.right);
                stackQ.push(tempQ.right);
            } else if (tempP.right == null && tempQ.right == null) {
            } else return false;
        }
        if (!stackP.isEmpty() || !stackQ.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(1);
        q.right = new TreeNode(4);

        System.out.println(isSameTreeRecursively(p, q));
        System.out.println(isSameTreeIteratively(p, q));
    }
}
