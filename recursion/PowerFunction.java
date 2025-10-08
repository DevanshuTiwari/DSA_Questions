package recursion;

public class PowerFunction {
    public static void main(String[] args) {
        double x = 2;
        int n = 5;

        double ans = myPow(x, n);

        System.out.println(ans);
    }

    private static double myPow(double x, int n) {
        long N = n;

        if (N < 1) {
            x = 1 / x;
            N = -N;
        }

        return helper(x, N);
    }

    // O(logN)
    private static double helper(double x, long n) {
        if (n == 0) return 1.0;

        double half = helper(x, n / 2);

        double ans = half * half;

        if (n % 2 != 0) {
            ans *= x;
        }

        return ans;
    }

    // Brute force 0(N) ---> slow if n is very large
//    private static double myPow(double x, int n) {
//        long N = n;
//
//        if (N == 0) return 1.0;
//
//        if (N < 1) {
//            x = 1 / x;
//            N = -N;
//        }
//
//        double res = 1.0;
//        for (long i = 0; i < N; i++) {
//            res *= x;
//        }
//
//        return res;
//    }
}
