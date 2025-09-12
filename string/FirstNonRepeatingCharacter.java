package string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "leetcode";
        char ans = firstNonRepeating(s);

        System.out.println(ans);
    }

    private static char firstNonRepeating(String str) {

        Map<Character, Integer> mpp = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() == 1)
                //  return str.indexOf(entry.getKey()); -> for index
                //  For HashMap
                //  if (freq.get(str.charAt(i)) == 1) {
                //  return i;

                return entry.getKey();
        }

        return '$';
    }
}
