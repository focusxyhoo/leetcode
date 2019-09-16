package leetcode.medium;

import com.sun.source.tree.Tree;
import structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-19
 * time        : 14:38
 * description : https://leetcode.com/problems/validate-binary-search-tree/solution/
 * 思路一：递归，dfs
 * 思路二：迭代
 * 思路三：BST 的前序遍历是有序的
 */
public class T98_ValidateBinarySearchTree {

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
    // Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Validate Binary Search Tree.
    public static boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private static boolean dfs(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        int val = root.val;
        if (low != null && val <= low) return false;
        if (high != null && val >= high) return false;
        if (!dfs(root.left, low, val)) return false;
        if (!dfs(root.right, val, high)) return false;
        return true;
    }

    /**
     * 基本是将上面的递归方法改写成迭代。
     *
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {
        Integer lower = null, higher = null, val;
        update(root, lower, higher);
        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = low.poll();
            higher = high.poll();

            if (null == root) continue;
            val = root.val;
            if (lower != null && val <= lower) return false;
            if (higher != null && val >= higher) return false;
            update(root.left, lower, val);
            update(root.right, val, higher);
        }
        return true;
    }

    static LinkedList<TreeNode> stack = new LinkedList<>();
    static LinkedList<Integer> low = new LinkedList<>(), high = new LinkedList<>();

    private static void update(TreeNode root, Integer lower, Integer higher) {
        stack.add(root);
        low.add(lower);
        high.add(higher);
    }

    public static boolean isValidBST3(TreeNode root) {
        List<Integer> list = getPreOrder(root);
        return true;
    }

    private static List<Integer> getPreOrder(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        preOrderCore(root, ans);
        return ans;
    }

    private static void preOrderCore(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        preOrderCore(root.left, ans);
        preOrderCore(root.right, ans);
    }

    private static void isIncreasing(List<Integer> list) {
        for (Integer integer : list) {

        }
    }
}
