package binarytree;

public class MinCamera {
    public static void main(String[] args) {
        int[] arr = {0, 0, -1, 0, 0};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        int ans = minCameraCover(root);
        System.out.println(ans);
    }

    static int countCameras = 0;

    private static int minCameraCover(TreeNode root) {
        int state = helper(root);

        if (state == 0) {
            countCameras++;
        }

        return countCameras;

    }

    private static int helper(TreeNode root) {
        if (root == null) {
            return 2;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if (left == 0 || right == 0) {
            countCameras++;
            return 1;
        }

        if (left == 1 || right == 1) {
            return 2;
        }

        return 0;
    }
}
