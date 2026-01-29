package binarytree;

public class TrimTree {
    public static void main(String[] args) {
        int[] arr = {3, 0, 4, -1, 2, -1, -1, 1};

        TreeNode node = BinaryTreeUtils.buildTree(arr);
        TreeNode ans = trimBST(node, 1, 3);
        BinaryTreeUtils.printTree(ans);
    }

    private static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
