package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3, 6, 9};

        TreeNode root = BinaryTreeUtils.buildTree(arr);

        TreeNode ansTree = invertTreeRecursive(root);
        BinaryTreeUtils.printTree(ansTree);

        TreeNode iterativeTree = invertTreeIterative(root);
        BinaryTreeUtils.printTree(iterativeTree);
    }

    private static TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        return root;
    }

    private static TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }

        return root;
    }
}
