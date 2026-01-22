package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideOfBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -1, -1, 4};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        System.out.println(rightSideIterative(root));
        System.out.println(res(root, 0));
    }

    private static List<Integer> res(TreeNode root, int level) {
        List<Integer> list = new ArrayList<>();
        rightSideDfs(root, 0, list);
        return list;
    }

    private static void rightSideDfs(TreeNode root, int level, List<Integer> list) {
        if (root == null) return;

        if (level == list.size()) {
            list.add(root.val);
        }

        rightSideDfs(root.right, level + 1, list);
        rightSideDfs(root.left, level + 1, list);

    }

    private static List<Integer> rightSideIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (i == size - 1) {
                    list.add(curr.val);
                }

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }

        return list;
    }
}
