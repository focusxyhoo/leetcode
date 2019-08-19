package leetcode.medium;

import structure.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-19
 * time        : 13:27
 * description : 将一个二叉搜索树上的所有节点的值，更改为树上其他大于等于其节点的值之和。
 */
public class T1038_BinarySearchTree2GreaterSumTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        TreeNode newRoot = bst2Gst(root);
        preTraversal(newRoot);
        System.out.println(preOrder.toString());
    }

    /**
     * 因为二叉搜索树的前序遍历即是有序的，因此可以考虑根据前序遍历的结果，对树中的每个节点，
     * 查找序列中比其大的元素，并求和替代原值。
     * 问题：两边遍历，得不偿失。
     *
     * @param root
     * @return
     */
    public static TreeNode bst2Gst(TreeNode root) {
        preTraversal(root);
        second(root);
        return root;
    }

    // 保存前序遍历序列。
    public static List<Integer> preOrder = new LinkedList<>();

    /**
     * 递归前序遍历二叉搜索树。
     *
     * @param root
     */
    public static void preTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        preTraversal(root.left);
        preOrder.add(root.val);
        preTraversal(root.right);
    }

    /**
     * 对 BST 中的每个节点，其右子树上的所有节点均大于其值。
     * 根据这一特点可以边遍历（必须是前序遍历）边修改其值。
     *
     * @param root
     * @return
     */
    public static void second(TreeNode root) {
        if (root == null) {
            return;
        }
        second(root.left);
        root.val = getSum(root);
        second(root.right);
    }

    /**
     * 获得新值。
     *
     * @param root
     * @return
     */
    public static int getSum(TreeNode root) {
        Iterator it = preOrder.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int temp = (int) it.next();
            if (temp >= root.val) {
                sum += temp;
            }
        }
        return sum;
    }
}
