package stack;

import java.util.Stack;

public class EvaluateRPN {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int ans = evlRPN(tokens);

        System.out.println(ans);
    }

    private static int evlRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (isInteger(token)) {
                st.push(Integer.parseInt(token));
            }

            switch (token) {
                case "+" -> {
                    if (!st.isEmpty()) {
                        int first = st.pop();
                        int second = st.pop();

                        st.push(first + second);
                    }
                }
                case "-" -> {
                    if (!st.isEmpty()) {
                        int first = st.pop();
                        int second = st.pop();

                        st.push(second - first);
                    }
                }
                case "*" -> {
                    if (!st.isEmpty()) {
                        int first = st.pop();
                        int second = st.pop();

                        st.push(first * second);
                    }
                }
                case "/" -> {
                    if (!st.isEmpty()) {
                        int first = st.pop();
                        int second = st.pop();

                        st.push(second / first);
                    }
                }
            }
        }

        return st.peek();
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
