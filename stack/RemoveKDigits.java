package stack;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        String ans = removeKdigits(num, k);
        System.out.println(ans);

    }

    private static String removeKdigits(String num, int k) {
        if (num == null || num.isEmpty()) return "";

        Stack<Character> st = new Stack<>();

        for (char ch : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && ch < st.peek()) {
                st.pop();
                k--;
            }

            st.push(ch);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        if (ans.isEmpty()) {
            return "0";
        }

        return ans.toString();

    }
}
