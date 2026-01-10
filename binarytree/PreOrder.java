package binarytree;

public class PreOrder {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,-1,8,-1,-1,6,7,9};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        preOrder(root);
    }

    private static void preOrder(TreeNode root){
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}