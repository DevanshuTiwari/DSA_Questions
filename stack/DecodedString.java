package stack;

import java.util.Stack;

public class DecodedString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String ans = decoder(s);

        System.out.println(ans);
    }

    private static String decoder(String s) {
        if (s == null || s.isEmpty()) return "";

        Stack<Integer> numCount = new Stack<>();
        Stack<StringBuilder> decodeString = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numCount.push(num);
                decodeString.push(curr);

                curr = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                StringBuilder decode = new StringBuilder();
                int cnt = numCount.pop();

                for (int i = 0; i < cnt; i++) {
                    decode.append(curr);
                }

                curr = decodeString.pop().append(decode);
            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}
