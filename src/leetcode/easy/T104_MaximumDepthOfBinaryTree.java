package easy;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-21
 * time        : 11:08
 * description :
 */
public class T104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth2(root));
    }


    /**
     * 对于树来说，采用递归来解决问题是非常简便的。
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 如果改用迭代，首先需要想到的是树的各种遍历方法。这里要求深度，可以考虑层次遍历。
     * 需要一个队列来存放访问的节点。
     * 在每一层的最后一个节点后面放置一个 null 节点，以表示该层结束，depth 加一。
     *
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        // 新建队列，不推荐使用 add 和 remove 方法，因为其在失败时会抛出异常。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int depth = 0;
        while (!queue.isEmpty()) {
//            depth++;
            TreeNode temp = queue.poll();
            if (temp == null) {
                depth++;
                continue;
            }
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
            if (queue.peek() == null) {
                queue.offer(null);
            }
        }
        return depth - 1;
    }

}
