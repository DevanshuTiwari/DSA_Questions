package binarytree;

import java.util.HashMap;

public class PathSumNotWithOrWithoutRoot {
    public static void main(String[] args) {
        int[] arr = {10, 5, -3, 3, 2, -1, 11, 3, -2, -1, 1};

        TreeNode node = BinaryTreeUtils.buildTree(arr);
        int ans = pathSum(node, 8);
        System.out.println(ans);
    }

    private static int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> mpp = new HashMap<>();

        mpp.put(0L, 1);

        return helper(root, 0L, targetSum, mpp);
    }

    private static int helper(TreeNode root, long current, int targetSum, HashMap<Long, Integer> map) {
        if (root == null) return 0;

        current += root.val;

        int cnt = map.getOrDefault(current - targetSum, 0);

        map.put(current, map.getOrDefault(current, 0) + 1);

        cnt += helper(root.left, current, targetSum, map);
        cnt += helper(root.right, current, targetSum, map);

        map.put(current, map.get(current) - 1);

        return cnt;

    }
}