package binarytree;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class WidthOfBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 3, -1, 9};

        TreeNode node = BinaryTreeUtils.buildTree(arr);
        int ans = width(node);
        System.out.println(ans);
    }

    private static int width(TreeNode node) {
        if (node == null) return 0;

        int maxWidth = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minIdx = q.peek().index;

            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();

                int currIdx = curr.index - minIdx;

                TreeNode currNode = curr.node;

                if (i == 0) first = currIdx;
                if (i == size - 1) last = currIdx;

                if (currNode.left != null) {
                    q.add(new Pair(currNode.left, currIdx * 2));
                }

                if (currNode.right != null) {
                    q.add(new Pair(currNode.right, currIdx * 2 + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
