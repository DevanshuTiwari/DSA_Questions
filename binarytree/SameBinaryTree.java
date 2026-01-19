package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SameBinaryTree {
    public static void main(String[] args) {
        int[] p = {1, 2, 3};
        int[] q = {1, 2, 3};

        TreeNode a = BinaryTreeUtils.buildTree(p);
        TreeNode b = BinaryTreeUtils.buildTree(q);

        boolean ans = isSameTree(a, b);
        System.out.println(ans);

        boolean ansIterative = isSameTreeIterative(a, b);
        System.out.println(ansIterative);
    }

    private static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val == b.val) {
            return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
        }

        return false;
    }

    private static boolean isSameTreeIterative(TreeNode a, TreeNode b) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();

        queueA.add(a);
        queueB.add(b);

        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            TreeNode nodeP = queueA.poll();
            TreeNode nodeQ = queueB.poll();

            if (nodeP == null && nodeQ == null) {
                continue;
            }

            if (nodeP == null || nodeQ == null) {
                return false;
            }

            if (nodeP.val != nodeQ.val) {
                return false;
            }

            queueA.add(nodeP.left);
            queueB.add(nodeQ.left);

            queueA.add(nodeP.right);
            queueB.add(nodeQ.right);
        }

        return true;
    }
}
