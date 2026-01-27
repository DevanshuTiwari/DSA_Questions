package binarytree;

public class SumRootToLeaf {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        int ans = sumNumbers(root);
        System.out.println(ans);

    }

    private static int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }

    private static int findSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }

        return findSum(node.left, sum) + findSum(node.right, sum);
    }
}
