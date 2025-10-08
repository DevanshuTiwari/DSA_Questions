package recursion;

import java.util.Stack;

public class SortStackRecursion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);

        System.out.println("Before sort: " + st);

        sortStack(st);

        System.out.println("After sort: " + st);
    }

    private static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();

        sortStack(st);

        insertStack(st, top);
    }

    private static void insertStack(Stack<Integer> st, int ele) {
        if (st.isEmpty() || ele > st.peek()) {
            st.push(ele);
            return;
        }

        int top = st.pop();

        insertStack(st, ele);

        st.push(top);
    }
}
