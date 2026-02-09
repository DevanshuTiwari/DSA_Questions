package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {1, -1, 2, -1, 3, -1, 4, -1, -1};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        TreeNode ans = balanceBST(root);

        BinaryTreeUtils.printTree(ans);

    }

    static List<TreeNode> nodes = new ArrayList<>();

    private static TreeNode balanceBST(TreeNode root) {
        inOrder(root);

        return build(0, nodes.size() - 1);

    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        nodes.add(root);
        inOrder(root.right);
    }

    private static TreeNode build(int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode midNode = nodes.get(mid);

        midNode.left = build(start, mid - 1);
        midNode.right = build(mid + 1, end);

        return midNode;
    }
}
