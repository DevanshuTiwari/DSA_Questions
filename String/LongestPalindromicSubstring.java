package String;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String input = "babad";
        String ans = longestPalindromicSubstring(input);
        System.out.println(ans);
    }

    private static String longestPalindromicSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int currLen = 0;
        int maxLen = Integer.MIN_VALUE;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(i, j, s)) {
                    currLen = j - i + 1;
                    if (currLen > maxLen) {
                        maxLen = currLen;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }

        return ans;
    }

    private static boolean isPalindrome(int i, int j, String s1) {
        while (i < j) {
            if (s1.charAt(i) != s1.charAt(j)) return false;

            i++;
            j--;
        }
        return true;
    }
}
