package String;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean ans = isPalindrome(s.toLowerCase());
        System.out.println(ans);
    }


    private static boolean isPalindrome(String str) {
        int n = str.length();
        int i = 0, j = n - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(str.charAt(j))) {
                j--;
            } else if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
