package binarytree;

public class PostOrder {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,-1,8,-1,-1,6,7,9};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        postOrder(root);
    }

    private static void postOrder(TreeNode root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
}
