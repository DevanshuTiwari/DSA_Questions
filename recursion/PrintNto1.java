package recursion;

public class PrintNto1 {
    public static void main(String[] args) {
        print(7);

    }

    private static void print(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n);
        print(n - 1);
    }
}
