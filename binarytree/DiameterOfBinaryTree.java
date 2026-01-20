package binarytree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        int ans = diameterOfBinaryTree(root);
        System.out.println(ans);
    }

    static int maxDiameter = 0;

    private static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        heightOfBinaryTree(root);
        return maxDiameter;

    }

    private static int heightOfBinaryTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lHeight = heightOfBinaryTree(node.left);
        int rHeight = heightOfBinaryTree(node.right);

        maxDiameter = Math.max(maxDiameter, lHeight + rHeight);

        return Math.max(lHeight, rHeight) + 1;
    }
}