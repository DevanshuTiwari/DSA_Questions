package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBinaryTree {
    public static void main(String[] args) {
        int[] arr = {3, 9, 20, -1, -1, 15, 7};

        TreeNode node = BinaryTreeUtils.buildTree(arr);

        System.out.println(minDepth(node));
        System.out.println(minDepthIterative(node));
    }

    private static int minDepth(TreeNode node) {
        if (node == null) return 0;

        if (node.left == null) return minDepth(node.left) + 1;
        if (node.right == null) return minDepth(node.right) + 1;

        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }

    private static int minDepthIterative(TreeNode node) {
        if (node == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left == null && curr.right == null) {
                    return ans;
                }

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }

        return ans;
    }
}