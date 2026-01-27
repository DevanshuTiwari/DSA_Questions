package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        int[] arr = {3, 9, 20, -1, -1, 15, 7};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        System.out.println(zigZag(root));

    }

    private static List<List<Integer>> zigZag(TreeNode root) {
        List<List<Integer>> l1 = new ArrayList<>();
        if (root == null) {
            return l1;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean rev = false;

        while (!q.isEmpty()) {
            int level = q.size();

            List<Integer> l2 = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode curr = q.poll();

                if (rev) {
                    l2.add(0, curr.val);
                } else {
                    l2.add(curr.val);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            l1.add(l2);

            rev = !rev;
        }

        return l1;
    }
}
