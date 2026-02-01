package binarytree;

public class MaximumPathSum {
    public static void main(String[] args) {
        int[] arr = {-10, 9, 20, -1, -1, 15, 7};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        int ans = getMaxSum(root);
        System.out.println(ans);

    }


    static int globalMax = Integer.MIN_VALUE;

    private static int getMaxSum(TreeNode root) {
        getPathSum(root);
        return globalMax;
    }

    private static int getPathSum(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, getPathSum(root.left));
        int right = Math.max(0, getPathSum(root.right));

        int totalSum = root.val + left + right;
        globalMax = Math.max(globalMax, totalSum);

        return root.val + Math.max(left, right);
    }
}
