package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        TreeNode root = BinaryTreeUtils.buildTree(arr);

        boolean ans = isCompleteTree(root);
        System.out.println(ans);
    }

    private static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                flag = true;
            } else {
                if (flag) {
                    return false;
                }
                q.add(curr.left);
                q.add(curr.right);
            }
        }

        return true;
    }
}
