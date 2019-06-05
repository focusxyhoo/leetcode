package easy;

import structure.TreeNode;
import java.util.Stack;

public class T100_SameTree {
    public static boolean isSameTreeRecursively(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        // 注意这里一定要判断是否不相等
        if (p.val != q.val) return false;
        return isSameTreeRecursively(p.left, q.left) && isSameTreeRecursively(p.right, q.right);
    }

    public static boolean isSameTreeIteratively(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null && q != null || p != null && q == null)
            return false;
        Stack<TreeNode> pstack = new Stack<>();
        Stack<TreeNode> qstack = new Stack<>();
        pstack.add(p);
        qstack.add(q);
        while (!pstack.isEmpty() && !qstack.isEmpty()) {
            TreeNode ptemp = pstack.pop();
            TreeNode qtemp = qstack.pop();
            if (ptemp.val != qtemp.val)
                return false;
            if (ptemp.left != null && qtemp.left != null) {
                pstack.add(ptemp.left);
                qstack.add(qtemp.left);
            } else if (ptemp.left == null && qtemp.left == null) {
                // 当左子树都为空时，不进行任何操作。
            } else {
                return false;
            }
            if (ptemp.right != null && qtemp.right != null) {
                pstack.add(ptemp.right);
                qstack.add(qtemp.right);
            } else if (ptemp.right == null && qtemp.right == null) {
            } else {
                return false;
            }
        }
        if (!pstack.isEmpty() || !qstack.isEmpty()) {
            return false;
        }
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
