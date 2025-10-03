package recursion;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }

    private static boolean isPowerOfTwo(int n) {

        if (n < 1) return false;

        if (n == 1) return true;

        if (n % 2 != 0) return false;

        return isPowerOfTwo(n / 2);

//        if(n < 1) return false;
//
//        while(n % 2 == 0){
//            n /= 2;
//        }
//
//        return n == 1;
    }
}
