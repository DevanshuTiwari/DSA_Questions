package stack;

import java.util.Stack;

public class RemoveOuterMostParenthesis {
    public static void main(String[] args) {
        String s = "(()())(())";
        String ans = removeOuterMostBrackets(s);

        System.out.println(ans);
    }

    private static String removeOuterMostBrackets(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0) {
                    sb.append(c);
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
