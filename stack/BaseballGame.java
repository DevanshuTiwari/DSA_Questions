package stack;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        int points = calculateScore(ops);

        System.out.println(points);
    }

    private static int calculateScore(String[] ops) {
        if (ops == null || ops.length == 0) return 0;

        Stack<Integer> st = new Stack<>();

        for (String str : ops) {
            if (isInteger(str)) {
                st.push(Integer.parseInt(str));
            } else if (str.equals("C")) {
                if (!st.isEmpty()) st.pop();
            } else if (str.equals("D")) {
                if (!st.isEmpty()) st.push(2 * st.peek());
            } else if (str.equals("+")) {
                if (st.size() >= 2) {
                    int top = st.pop();
                    int newTop = top + st.peek();
                    st.push(top);
                    st.push(newTop);
                }
            }
        }

        // Sum the stack
        int score = 0;
        for (int num : st) score += num;

        return score;
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
