package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBinaryTree {
    public static void main(String[] args) {
        int[] arr = {3, 9, 20, -1, -1, 15, 7};

        TreeNode node = BinaryTreeUtils.buildTree(arr);
        System.out.println(maxDepth(node));
        System.out.println(maxDepthIterative(node));
    }

    private static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lMax = maxDepth(node.left);
        int rMax = maxDepth(node.right);

        return Math.max(lMax, rMax) + 1;
    }

    private static int maxDepthIterative(TreeNode node) {
        if (node == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }

        return ans;
    }
}
