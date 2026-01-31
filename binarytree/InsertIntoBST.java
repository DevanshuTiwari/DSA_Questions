package binarytree;

public class InsertIntoBST {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3};

        TreeNode node = BinaryTreeUtils.buildTree(arr);
        TreeNode ans = insert(node, 5);

        BinaryTreeUtils.printTree(ans);

    }

    private static TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val > node.val) {
            node.right = insert(node.right, val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        }

        return node;
    }
}