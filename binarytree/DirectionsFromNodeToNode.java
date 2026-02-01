package binarytree;

public class DirectionsFromNodeToNode {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, -1, 6, 4};


        TreeNode root = BinaryTreeUtils.buildTree(arr);
        String ans = getDirections(root, 3, 6);
        System.out.println(ans);
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {

        StringBuilder startPath = new StringBuilder();
        StringBuilder desPath = new StringBuilder();

        isPathExists(root, startValue, startPath);
        isPathExists(root, destValue, desPath);

        int i = 0;
        while (i < startPath.length() && i < desPath.length() && startPath.charAt(i) == desPath.charAt(i)) {
            i++;
        }

        StringBuilder res = new StringBuilder();
        for (int j = i; j < startPath.length(); j++) {
            res.append('U');
        }

        res.append(desPath.substring(i));

        return res.toString();

    }

    private static boolean isPathExists(TreeNode node, int val, StringBuilder path) {
        if (node == null) return false;
        if (node.val == val) return true;

        path.append('L');
        if (isPathExists(node.left, val, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (isPathExists(node.right, val, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}
