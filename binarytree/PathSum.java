package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {
        int[] arr = {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        System.out.println(pathSum(root, 22));

    }

    private static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(root, target, res, curr);
        return res;
    }

    private static void helper(TreeNode root, int remaining, List<List<Integer>> res, List<Integer> curr) {
        if (root == null) return;

        curr.add(root.val);

        if (root.left == null && root.right == null && root.val == remaining) {
            res.add(new ArrayList<>(curr)); // copy of reference
        }

        helper(root.left, remaining - root.val, res, curr);
        helper(root.right, remaining - root.val, res, curr);

        curr.remove(curr.size() - 1);
    }
}
