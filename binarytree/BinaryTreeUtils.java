package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtils {
    public static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if (arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}