package stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "(){}[]";
        boolean ans = isValidParenthesis(s);

        System.out.println(ans);
    }

    private static boolean isValidParenthesis(String s) {
        if (s == null || s.isEmpty()) return false;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '[')) {
                st.push(s.charAt(i));
            } else {
                if (st.empty()) return false;


                char top = st.pop();
                if ((s.charAt(i) == ')' && top != '(') || (s.charAt(i) == '}' && top != '{') || (s.charAt(i) == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
