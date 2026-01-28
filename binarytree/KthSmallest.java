package binarytree;

import java.util.Stack;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, -1, 2};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        int ans = kthSmallest(root, 1);
        System.out.println(ans);

        int ansIterative = kthSmallestIterative(root, 1);
        System.out.println(ansIterative);
    }

    static int count = 0;
    static int res = 0;

    private static int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private static void traverse(TreeNode root, int k) {
        if (root == null) return;

        traverse(root.left, k);
        count++;

        if (count == k) {
            res = root.val;
            return;
        }

        if (count > k) return;

        traverse(root.right, k);
    }

    private static int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        int count = 0;

        while (curr != null || !st.empty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            count++;

            if (count == k) {
                return curr.val;
            }

            curr = curr.right;
        }

        return -1;
    }
}
