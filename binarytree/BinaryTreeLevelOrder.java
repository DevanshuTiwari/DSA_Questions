package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        int[] arr = {3, 9, 20, -1, -1, 15, 7};

        TreeNode root = BinaryTreeUtils.buildTree(arr);

        System.out.println(binaryTreeLevelOrder(root));
    }

    private static List<List<Integer>> binaryTreeLevelOrder(TreeNode root) {
        List<List<Integer>> l1 = new ArrayList<>();
        if (root == null) {
            return l1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> l2 = new ArrayList<>();
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                l2.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            l1.add(l2);
        }

        return l1;

    }
}
