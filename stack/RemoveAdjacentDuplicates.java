package stack;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        String ans = removeAdjacent(s);

        System.out.println(ans);
    }

    private static String removeAdjacent(String str) {
        if (str == null || str.length() == 0) return "";

        Stack<Character> st = new Stack<>();
        for (char c : str.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
