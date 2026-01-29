package binarytree;

import java.util.ArrayList;
import java.util.List;

public class NodesDistanceK {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        TreeNode targetNode = findNode(root, 5);

        if (targetNode != null) {
            System.out.println(distanceK(root, targetNode, 2));
        } else {
            System.out.println("Target node not found in tree.");
        }
    }

static List<Integer> res;

private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    res = new ArrayList<>();
    findTargetAndSearch(root, target, k);
    return res;
}

private static int findTargetAndSearch(TreeNode root, TreeNode target, int k) {
    if (root == null) return -1;

    if (root == target) {
        helper(root, k);
        return 1;
    }

    int leftDist = findTargetAndSearch(root.left, target, k);
    if (leftDist != -1) {
        if (leftDist == k) res.add(root.val);
        helper(root.right, k - leftDist - 1);

        return leftDist + 1;
    }

    int rightDist = findTargetAndSearch(root.right, target, k);
    if (rightDist != -1) {
        if (rightDist == k) res.add(root.val);

        helper(root.left, k - rightDist - 1);

        return rightDist + 1;
    }

    return -1;
}

private static void helper(TreeNode node, int k) {
    if (node == null || k < 0) return;
    if (k == 0) {
        res.add(node.val);
        return;
    }
    helper(node.left, k - 1);
    helper(node.right, k - 1);
}

private static TreeNode findNode(TreeNode root, int value) {
    if (root == null) return null;
    if (root.val == value) return root;

    TreeNode left = findNode(root.left, value);
    if (left != null) return left;

    return findNode(root.right, value);
}
}
