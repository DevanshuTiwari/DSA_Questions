package binarytree;

public class CountGoodNodes {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 3, -1, 1, 5};

        TreeNode node = BinaryTreeUtils.buildTree(arr);
        int ans = goodNodes(node);
        System.out.println(ans);

    }

    private static int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private static int countGoodNodes(TreeNode root, int maxVal) {
        if (root == null) return 0;

        int count = 0;
        if (root.val >= maxVal) {
            count = 1;
            maxVal = root.val;
        }

        int leftCount = countGoodNodes(root.left, maxVal);
        int rightCount = countGoodNodes(root.right, maxVal);

        return count + leftCount + rightCount;
    }
}
