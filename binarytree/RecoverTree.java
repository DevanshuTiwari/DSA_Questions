package binarytree;

public class RecoverTree {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -1, 2};

        TreeNode node = BinaryTreeUtils.buildTree(arr);

        recover(node);

        BinaryTreeUtils.printTree(node);
    }

    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = null;


    private static void recover(TreeNode node) {
        traverseInorder(node);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private static void traverseInorder(TreeNode node) {
        if (node == null) return;

        traverseInorder(node.left);

        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
                second = node;
            } else {
                second = node;
            }
        }

        prev = node;

        traverseInorder(node.right);
    }
}
