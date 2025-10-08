package recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephProblem {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        int ans = winnerPos(n, k);

        System.out.println(ans);
    }


    // Recursive approach without extra space
    private static int winnerPos(int n, int k) {
        int winner = 0;

        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }

        return winner + 1;
    }

    // Recursive approach with extra space
//    private static int winnerPos(int n, int k) {
//
//        return helper(n, k) + 1;
//    }
//
//    private static int helper(int n, int k) {
//        if (n == 1) return 0;
//
//        return (helper((n - 1), k) + k) % n;
//    }

    // Brute approach ---> O(n^2)
//    private static int winnerPos(int n, int k) {
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 1; i <= n; i++) {
//            list.add(i);
//        }
//
//
//        int curr = 0;
//        k--;
//
//        while (list.size() > 1) {
//            curr = (curr + k) % list.size();
//            list.remove(curr);
//        }
//
//        return list.getFirst();
//    }
}
