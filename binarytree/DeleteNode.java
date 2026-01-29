package binarytree;

public class DeleteNode {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 4, -1, 7};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        TreeNode ans = deleteNode(root, 3);

        BinaryTreeUtils.printTree(ans);
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                TreeNode successor = findMin(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }

        }
        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
