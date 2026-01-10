package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        int[] arr = {3, 9, 20, 15, 7};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        List<Integer> bfs = levelOrder(root);

        System.out.println(bfs);
    }

    private static List<Integer> levelOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return ans;
    }
}