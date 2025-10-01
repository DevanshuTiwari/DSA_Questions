package stack;

import java.util.Stack;

public class Pattern132 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        boolean ans = findPattern132(nums);

        System.out.println(ans);
    }

    private static boolean findPattern132(int[] nums) {
        int n = nums.length;

        if (n < 3) return false;

        Stack<Integer> st = new Stack<>();
        int b = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            int a = nums[i];

            if (a < b) return true; // a < b < c

            while (!st.isEmpty() && a > st.peek()) {
                b = st.pop();
            }

            st.push(a);
        }

        return false;
    }
}
