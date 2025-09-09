package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> ans = validAnagrams(input);
        System.out.println(ans);
    }


    // Optimal approach - O(N * K log K)
    private static List<List<String>> validAnagrams(String[] str) {
        if (str == null || str.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> mpp = new HashMap<>();
        for (String currString : str) {
            char[] ch = currString.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch); // eat -> "aet"

            if (!mpp.containsKey(sorted)) {
                mpp.put(sorted, new ArrayList<>());
            }

            mpp.get(sorted).add(currString);
        }

        return new ArrayList<>(mpp.values());
    }


    // Brute approach - O(N^2 * K log K)
//    private static List<List<String>> validAnagrams(String[] str) {
//        if (str == null || str.length == 0) {
//            return new ArrayList<>();
//        }
//
//        List<List<String>> results = new ArrayList<>();
//        boolean[] marked = new boolean[str.length];
//
//        for (int i = 0; i < str.length; i++) {
//            List<String> group = new ArrayList<>();
//            if (!marked[i]) {
//                group.add(str[i]);
//                marked[i] = true;
//
//                for (int j = i + 1; j < str.length; j++) {
//                    if (!marked[j] && isAnagram(str[i], str[j])) {
//                        group.add(str[j]);
//                        marked[j] = true;
//                    }
//                }
//
//                results.add(group);
//            }
//        }
//
//        return results;
//    }
//
//    private static boolean isAnagram(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//
//        char[] c1 = s1.toCharArray();
//        char[] c2 = s2.toCharArray();
//
//        Arrays.sort(c1);
//        Arrays.sort(c2);
//
//        return Arrays.equals(c1, c2);
//    }
}
