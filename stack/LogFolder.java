package stack;

import java.util.Stack;

public class LogFolder {
    public static void main(String[] args) {
        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
        int minNumberOfSteps = numberOfSteps(logs);

        System.out.println(minNumberOfSteps);
    }

    private static int numberOfSteps(String[] logs) {
        if (logs == null || logs.length == 0) return 0;

        Stack<String> st = new Stack<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                st.push(log);
            }
        }
        return st.size();
    }
}
