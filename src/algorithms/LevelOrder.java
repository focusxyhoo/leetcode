package algorithms;

import structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/17
 * time        : 23:42
 * description : 层序遍历打印二叉树，每层一行。
 */
public class LevelOrder {
    // print by line
    public static void levelOrderByLine(TreeNode root) {
        if (root == null) return;
        int curLevelCount = 1, nextLevelCount = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curNode;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            System.out.print(curNode.val + " ");
            curLevelCount--;
            if (null != curNode.left) {
                queue.offer(curNode.left);
                nextLevelCount++;
            }
            if (null != curNode.right) {
                queue.offer(curNode.right);
                nextLevelCount++;
            }
            if (0 == curLevelCount) {
                System.out.println();
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
    }

    public static void levelOrderWithLineNum(TreeNode root) {
        if (root == null) return;
        TreeNode rightestNode = root;
        TreeNode nextRightestNode = null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curNode;
        int lineNum = 1;
        while (!queue.isEmpty()) {
            curNode = queue.poll();


        }
    }

    public static void main(String[] args) {
        //                1
        //               / \
        //              2   3
        //             /   / \
        //            4   5   6
        //             \     /
        //              7   8
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(8);

        levelOrderByLine(root);
    }
}
