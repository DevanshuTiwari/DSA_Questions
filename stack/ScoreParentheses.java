package stack;

import java.util.Stack;

public class ScoreParentheses {
    public static void main(String[] args) {
        String s = "(()())";
        int ans = scoreOfParentheses(s);

        System.out.println(ans);
    }

    public static int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        st.push(0);

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(0);
            } else {
                int innerScore = st.pop();
                int outerScore = st.pop();

                int totalScore = Math.max(2 * innerScore, 1);

                st.push(outerScore + totalScore);
            }
        }

        return st.pop();
    }
}
