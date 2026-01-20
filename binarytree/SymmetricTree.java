package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 3};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        boolean ans = isSymmetricRec(root);
        System.out.println(ans);

        boolean ansIter = isSymmetricIterative(root);
        System.out.println(ansIter);
    }

    private static boolean isSymmetricRec(TreeNode root) {
        if (root == null) return true;

        return isMirrorOrNot(root.left, root.right);

    }

    private static boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode nodeP = queue.poll();
            TreeNode nodeQ = queue.poll();

            if (nodeP == null && nodeQ == null) {
                continue;
            }

            if (nodeP == null || nodeQ == null) {
                return false;
            }

            if (nodeP.val != nodeQ.val) {
                return false;
            }

            queue.add(nodeP.left);
            queue.add(nodeQ.right);

            queue.add(nodeP.right);
            queue.add(nodeQ.left);
        }
        return true;
    }

    private static boolean isMirrorOrNot(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val == b.val) {
            return isMirrorOrNot(a.left, b.right) && isMirrorOrNot(a.right, b.left);
        }

        return false;
    }
}