package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -1, -1, 4, 5};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        String ans = serialize(root);
        System.out.println(ans);

        TreeNode res = deserialize("1 2 3 # # 4 5");
        BinaryTreeUtils.printTree(res);
    }

    private static String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder str = new StringBuilder();

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                str.append(" #,");
                continue;
            }

            str.append(curr.val + ",");
            q.add(curr.left);
            q.add(curr.right);

        }
        return str.toString();
    }

    private static TreeNode deserialize(String s) {
        if (s == "") return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] val = s.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));

        q.add(root);

        for (int i = 1; i < val.length; i++) {
            TreeNode curr = q.poll();
            if (!val[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(val[i]));
                curr.left = left;
                q.add(left);
            }

            i++;

            if (i < val.length && !val[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(val[i]));
                curr.right = right;
                q.add(right);
            }
        }

        return root;
    }
}
