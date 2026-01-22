package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathInBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 3, -1};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        System.out.println(pathFind(root));

    }

    private static List<Integer> pathFind(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        isPathExists(root, 5, list);

        return list;
    }

    private static boolean isPathExists(TreeNode root, int target, List<Integer> path) {
        if (root == null) return false;

        path.add(root.val);

        if (root.val == target) return true;

        if (isPathExists(root.left, target, path) || isPathExists(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }
}
