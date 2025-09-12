package string;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";

        boolean ans = isValidAnagram(str1, str2);
        System.out.println(ans);
    }

    private static boolean isValidAnagram(String s1, String s2) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);

            if (!mpp.containsKey(ch)) {
                return false;
            }

            mpp.put(ch, mpp.get(ch) - 1);

            if (mpp.get(ch) == 0) {
                mpp.remove(ch);
            }
        }

        return mpp.isEmpty();
    }
}
