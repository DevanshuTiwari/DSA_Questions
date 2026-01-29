package binarytree;

public class HouseRobber3 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, -1, 3, 1};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        int ans = maxAmount(root);
        System.out.println(ans);
    }

    private static int maxAmount(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int withNode = root.val + left[1] + right[1];
        int withoutNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{withNode, withoutNode};

    }
}
