package binarytree;

public class MorrisTraversal {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        morrisTraversal(root);
    }

    private static void morrisTraversal(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val);
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    System.out.print(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}
