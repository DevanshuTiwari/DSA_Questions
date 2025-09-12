package string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcbcbaa";
        int ans = longestSubstring(s);

        System.out.println(ans);
    }

    private static int longestSubstring(String str) {
        int n = str.length();
        int i = 0, j = 0;
        int maxLen = 0;

        HashMap<Character, Integer> mpp = new HashMap<>();

        while (j < n) {
            char ch1 = str.charAt(j);
            mpp.put(ch1, mpp.getOrDefault(ch1, 0) + 1);

            if (mpp.size() == j - i + 1) { // window size == unique characters
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }

            else if (mpp.size() < j - i + 1) {
                while (mpp.size() < j - i + 1) {
                    char ch2 = str.charAt(i);
                    mpp.put(ch2, mpp.get(ch2) - 1);
                    if (mpp.get(ch2) == 0) {
                        mpp.remove(ch2);
                    }
                    i++;
                }
                j++;
            }
        }

        return maxLen;
    }
}
