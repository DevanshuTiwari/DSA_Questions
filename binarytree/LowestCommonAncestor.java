package binarytree;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        TreeNode ans = lowestCA(root, 5, 4);

        if (ans != null) {
            System.out.println(ans.val);
        } else {
            System.out.println("Not found");
        }

    }

    private static TreeNode lowestCA(TreeNode root, int a, int b) {
        if (root == null || root.val == a || root.val == b) {
            return root;
        }

        TreeNode left = lowestCA(root.left, a, b);
        TreeNode right = lowestCA(root.right, a, b);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
