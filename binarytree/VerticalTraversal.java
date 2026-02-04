package binarytree;

import java.util.*;

class Point {
    int row;
    int val;

    Point(int row, int val) {
        this.row = row;
        this.val = val;
    }
}

class Tuple {
    TreeNode node;
    int col;
    int row;

    Tuple(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

public class VerticalTraversal {
    public static void main(String[] args) {
        int[] arr = {3, 9, 20, -1, -1, 15, 7};

        TreeNode root = BinaryTreeUtils.buildTree(arr);
        List<List<Integer>> res = verticalTraversal(root);

        System.out.println(res);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Point>> map = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            TreeNode node = current.node;
            int x = current.col;
            int y = current.row;

            map.putIfAbsent(x, new PriorityQueue<>((a, b) -> {
                if (a.row != b.row) {
                    return a.row - b.row;
                }
                return a.val - b.val;
            }));

            map.get(x).add(new Point(y, node.val));

            if (node.left != null) {
                queue.add(new Tuple(node.left, x - 1, y + 1));
            }

            if (node.right != null) {
                queue.add(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (PriorityQueue<Point> pq : map.values()) {
            List<Integer> colList = new ArrayList<>();
            while (!pq.isEmpty()) {
                colList.add(pq.poll().val);
            }
            result.add(colList);
        }

        return result;
    }
}
