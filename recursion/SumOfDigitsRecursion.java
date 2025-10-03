package recursion;

public class SumOfDigitsRecursion {
    public static void main(String[] args) {
        int n = 38; // 38 ---> 3 + 8 = 11 ---> 1 + 1 = 2
        System.out.println(sum(n));
    }

    private static int sum(int n) {

        if (n < 10) return n;

        return 1 + sum(n - 1) % 9; // digit root formula


//        Using recursion - O(log n)
//        int sum = 0;
//        while (n != 0){
//            sum += n % 10;
//            n /= 10;
//        }
//
//        return sum(sum);


//        if (n == 0) return n;
//        return (n % 10) + sum(n / 10);

//        while(n >= 10) {
//            int sum = 0;
//            while (n != 0) {
//                int num = n % 10;
//                sum += num;
//                n = n / 10;
//            }
//             n = sum;
//        }
//
//        return n;
    }
}
