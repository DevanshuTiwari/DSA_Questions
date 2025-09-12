package string;

public class CountPalindromicSubstring {
    public static void main(String[] args) {
        String input = "aaa";
        String s = "racecar";
        int ans = countNumberOfPalindromicSubstring(input);

        System.out.println(ans);
        System.out.println(countNumberOfPalindromicSubstring(s));
    }


    // Optimal approach - O(N^2)
    private static int countNumberOfPalindromicSubstring(String str) {

        int count = 0;

        if (str == null || str.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < str.length(); i++) {

            // odd length
            count += expandFromCenter(str, i, i);

            // even length
            count += expandFromCenter(str, i, i + 1);
        }

        return count;
    }

    private static int expandFromCenter(String str, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            cnt++;

            left--;
            right++;
        }

        return cnt;
    }


    // Brute approach - O(N^3)
//    private static int countNumberOfPalindromicSubstring(String str) {
//        if (str == null || str.isEmpty()) {
//            return 0;
//        }
//        int count = 0;
//
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i; j < str.length(); j++) {
//                if (isPalindrome(i, j, str)) {
//                    count++;
//                }
//            }
//        }
//        return count;
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
