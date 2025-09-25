package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temp = {30, 40, 50, 60};
        int[] ans = dailyTemp(temp);

        System.out.println(Arrays.toString(ans));
    }

    private static int[] dailyTemp(int[] temp) {
        if (temp == null || temp.length == 0) return null;

        int n = temp.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>(); // to store indices
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temp[i] > temp[st.peek()]){
                int idx = st.pop();
                res[idx] = i - idx;
            }

            st.push(i);
        }

        return res;

    }
}
