package stack;

import java.util.Stack;

public class ValidStackSequence {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        boolean ans = validateStackSequences(pushed, popped);
        System.out.println(ans);
    }

    private static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;

        Stack<Integer> st = new Stack<>();
        int idx = 0;

        for (int num : pushed) {
            st.push(num);


            while (!st.isEmpty() && st.peek() == popped[idx]) {
                st.pop();
                idx++;
            }
        }


        return st.isEmpty();
    }
}
