package binarytree;

public class InOrder {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,-1,8,-1,-1,6,7,9};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        inOrder(root);
    }

    private static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
}