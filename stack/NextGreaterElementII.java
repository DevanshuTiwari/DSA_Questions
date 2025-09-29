package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int[] ans = nextGreater(arr);

        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>(); // index store

        for (int i = 0; i < 2 * n; i++) {
            int currIdx = i % n;
            int currNum = nums[currIdx];

            while (!st.isEmpty() && currNum > nums[st.peek()]) {
                int popIdx = st.pop();
                result[popIdx] = currNum;
            }

            if (i < n) {
                st.push(i);
            }
        }

        return result;
    }
}
