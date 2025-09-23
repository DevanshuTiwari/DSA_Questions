package stack;

import java.util.Stack;

public class BackStringComparison {
    public static void main(String[] args) {
        String s1 = "ab#c";
        String s2 = "ad#c";

        boolean ans = isEqual(s1, s2);
        System.out.println(ans);
    }

    private static boolean isEqual(String s1, String s2) {
        return build(s1).equals(build(s2));
    }

    private static String build(String str) {
        Stack<Character> st = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                st.push(c);
            } else if (!st.empty()) {
                st.pop();
            }
        }

        return String.valueOf(st);
    }
}
