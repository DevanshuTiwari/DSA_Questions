package recursion;

public class StringPalindromeRecursion {
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(isPalindrome(s, 0, s.length() - 1));
    }

    private static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) return true;

        if (s.charAt(left) != s.charAt(right)) return false;


        return isPalindrome(s, left + 1, right - 1);
    }
}
