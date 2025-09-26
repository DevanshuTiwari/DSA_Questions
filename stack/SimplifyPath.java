package stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/";
        String ans = simplifyPathDirectory(path);

        System.out.println(ans);
    }

    private static String simplifyPathDirectory(String path) {
        if (path == null || path.isEmpty()) return "";

        Stack<String> st = new Stack<>();
        String[] components = path.split("/");

        for (String s : components) {
            if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (s.isEmpty() || s.equals(".")) {
                continue;
            } else {
                st.push(s);
            }
        }

        if (st.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : st) {
            sb.append("/").append(dir);
        }


        return sb.toString();
    }
}
