package stack;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int ans = calculate(s);

        System.out.println(ans);
    }

    private static int calculate(String s) {
        if (s == null || s.isEmpty()) return -1;

        Stack<Integer> st = new Stack<>();
        int res = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res += sign * num;
                num = 0;

                res *= st.pop();
                res += st.pop();
            }
        }

        if (num != 0) {
            res += sign * num;
        }

        return res;
    }
}
