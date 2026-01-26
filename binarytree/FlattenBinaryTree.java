package binarytree;

import java.util.Stack;

public class FlattenBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, -1, 6};

        TreeNode node = BinaryTreeUtils.buildTree(arr);
        flatten(node);
        BinaryTreeUtils.printTree(node);

        flattenUsingStack(node);
        BinaryTreeUtils.printTree(node);

        flattenOptimal(node);
        BinaryTreeUtils.printTree(node);
    }

    static TreeNode prev = null;

    private static void flatten(TreeNode node) {
        if (node == null) return;

        flatten(node.right);
        flatten(node.left);

        node.right = prev;
        node.left = null;

        prev = node;

    }

    private static void flattenUsingStack(TreeNode node) {
        if (node == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            TreeNode curr = stack.pop();

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (!stack.empty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }

    private static void flattenOptimal(TreeNode node) {
        if (node == null) return;

        TreeNode curr = node;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }
}