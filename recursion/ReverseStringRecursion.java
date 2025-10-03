package recursion;

public class ReverseStringRecursion {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseStringRecursion(s));
    }

    private static String reverseStringRecursion(String s) {
        int n = s.length();

        if (n <= 1) return s;

        return reverseStringRecursion(s.substring(1)) + s.charAt(0);
    }
}
