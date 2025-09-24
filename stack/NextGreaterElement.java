package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] ans = nextGreaterElementRight(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreaterElementRight(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int num : nums2) {
            while (!st.isEmpty() && num > st.peek()) {
                mpp.put(st.pop(), num);
            }

            st.push(num);
        }

        while (!st.isEmpty()) {
            mpp.put(st.pop(), -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = mpp.get(nums1[i]);
        }

        return res;
    }
}
