package stack;


import java.util.Stack;

class Pair {
    Character ch;
    int count;

    public Pair(Character ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

public class RemoveAdjacentII {
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;

        String ans = removeKadjacent(s, k);
        System.out.println(ans);
    }

    private static String removeKadjacent(String s, int k) {
        if (s == null || s.isEmpty()) return "";

        Stack<Pair> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == c) {
                st.peek().count++;

                if (st.peek().count == k) {
                    st.pop();
                }
            } else {
                st.push(new Pair(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair p : st) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }
}
