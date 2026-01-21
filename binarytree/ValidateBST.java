package binarytree;

public class ValidateBST {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, -1, -1, 3, 6};

        TreeNode root = BinaryTreeUtils.buildTree(arr);

        boolean ans = validate(root, Long.MAX_VALUE, Long.MIN_VALUE);
        System.out.println(ans);
    }

    private static boolean validate(TreeNode root, long max, long min) {
        if (root == null) return true;

        // condition to check for the range
        if (root.val <= min || root.val >= max) {
            return false;
        }

        return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    }
}
