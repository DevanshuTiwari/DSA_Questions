package String;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String input = "babad";
        String ans = longestPalindromicSubstring(input);
        System.out.println(ans);
    }

    private static String longestPalindromicSubstring(String s) {
        if (s == null && s.isEmpty()) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);

    }

    private static int expandFromCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    // Brute Approach - O(N^3)
//    private static String longestPalindromicSubstring(String s) {
//        if (s == null || s.isEmpty()) {
//            return "";
//        }
//
//        int currLen = 0;
//        int maxLen = Integer.MIN_VALUE;
//        String ans = "";
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                if (isPalindrome(i, j, s)) {
//                    currLen = j - i + 1;
//                    if (currLen > maxLen) {
//                        maxLen = currLen;
//                        ans = s.substring(i, j + 1);
//                    }
//                }
//            }
//        }
//
//        return ans;
//    }
//
//    private static boolean isPalindrome(int i, int j, String s1) {
//        while (i < j) {
//            if (s1.charAt(i) != s1.charAt(j)) return false;
//
//            i++;
//            j--;
//        }
//        return true;
//    }
}
